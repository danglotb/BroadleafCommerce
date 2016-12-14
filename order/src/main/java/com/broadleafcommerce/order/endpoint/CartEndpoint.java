/*
 * #%L
 * BroadleafCommerce Order
 * %%
 * Copyright (C) 2009 - 2016 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package com.broadleafcommerce.order.endpoint;

import org.apache.commons.collections.CollectionUtils;
import org.broadleafcommerce.common.api.BaseEndpoint;
import org.broadleafcommerce.common.controller.FrameworkRestController;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.service.OfferService;
import org.broadleafcommerce.core.offer.service.exception.OfferException;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderMultishipOption;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.OrderMultishipOptionService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.AddToCartException;
import org.broadleafcommerce.core.order.service.exception.RemoveFromCartException;
import org.broadleafcommerce.core.order.service.exception.UpdateCartException;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.service.OrderPaymentService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.broadleafcommerce.order.common.domain.OrderAddress;
import com.broadleafcommerce.order.common.domain.OrderCustomer;
import com.broadleafcommerce.order.common.dto.OrderAddressDTO;
import com.broadleafcommerce.order.common.dto.OrderDTO;
import com.broadleafcommerce.order.common.dto.OrderPaymentDTO;
import com.broadleafcommerce.order.common.dto.SplitFulfillmentGroupDTO;
import com.broadleafcommerce.order.common.service.OrderCustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@FrameworkRestController(@RequestMapping(path = "/cart"))
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CartEndpoint extends BaseEndpoint {
    
    @Resource(name = "blOrderService")
    protected OrderService orderService;
    
    @Resource(name = "blOrderCustomerService")
    protected OrderCustomerService orderCustomerService;
    
    @Resource(name = "blOrderPaymentService")
    protected OrderPaymentService orderPaymentService;
    
    @Resource(name = "blOfferService")
    protected OfferService offerService;
    
    @Resource(name = "blFulfillmentGroupService")
    protected FulfillmentGroupService fulfillmentGroupService;
    
    @Resource(name = "blOrderMultishipOptionService")
    protected OrderMultishipOptionService orderMultishipOptionService;

    @RequestMapping(path = "/customer/{id}", method = RequestMethod.GET)
    public ResponseEntity findCartByCustomerId(HttpServletRequest request, @PathVariable Long id) {
        OrderCustomer customer = orderCustomerService.findOrderCustomerById(id);
        if (customer == null) {
            return new ResponseEntity("No customer with id " + id + " exists", HttpStatus.BAD_REQUEST);
        }
        Order order = orderService.findCartForCustomer(customer);
        if (order == null) {
            order = orderService.createNewCartForCustomer(customer);
        }
        OrderDTO response = (OrderDTO) context.getBean(OrderDTO.class.getName());
        response.wrapDetails(order, request);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity findCartById(HttpServletRequest request, @PathVariable Long id) {
        Order order = orderService.findOrderById(id);
        if (order == null) {
            return new ResponseEntity("No order exists with id " + id, HttpStatus.NOT_FOUND);
        }
        OrderDTO response = (OrderDTO) context.getBean(OrderDTO.class.getName());
        response.wrapDetails(order, request);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/customer/{customerId}", method = RequestMethod.POST)
    public ResponseEntity createNewCartForCustomer(HttpServletRequest request, @PathVariable Long customerId) {
        OrderCustomer customer = orderCustomerService.findOrderCustomerById(customerId);
        if (customer == null) {
            return new ResponseEntity("No customer found with id " + customerId, HttpStatus.BAD_REQUEST);
        }
        Order order = orderService.createNewCartForCustomer(customer);
        if (order == null) {
            return new ResponseEntity("An error occurred creating the cart for customer " + customerId, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        OrderDTO response = (OrderDTO) context.getBean(OrderDTO.class.getName());
        response.wrapDetails(order, request);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity createCart(HttpServletRequest request) {
        Order order = orderService.createCart();
        OrderDTO response = (OrderDTO) context.getBean(OrderDTO.class.getName());
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/{id}/add", method = RequestMethod.POST)
    public ResponseEntity addItemToOrder(HttpServletRequest request, @PathVariable Long id, @RequestBody OrderItemRequestDTO dto) {
        try {
            OrderDTO response = (OrderDTO) context.getBean(OrderDTO.class.getName());
            response.wrapDetails(orderService.addItem(id, dto, true), request);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (AddToCartException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(path = "/{orderId}/remove/{itemId}", method = RequestMethod.POST)
    public ResponseEntity removeItemFromOrder(HttpServletRequest request, @PathVariable("orderId") Long orderId, @PathVariable("itemId") Long orderItemId) {
        try {
            OrderDTO response = (OrderDTO) context.getBean(OrderDTO.class.getName());
            response.wrapDetails(orderService.removeItem(orderId, orderItemId, true), request);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (RemoveFromCartException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(path = "/{orderId}/udpate/{itemId}/options", method = RequestMethod.POST)
    public ResponseEntity updateItemOptions(HttpServletRequest request,
                                            @PathVariable("orderId") Long orderId,
                                            @PathVariable("itemId") Long itemId,
                                            @RequestBody Map<String, String> attributes) {
        OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
        orderItemRequestDTO.setItemAttributes(attributes);
        orderItemRequestDTO.setOrderItemId(itemId);
        try {
            return new ResponseEntity(orderService.updateProductOptionsForItem(orderId, orderItemRequestDTO, true), HttpStatus.OK);
        } catch (UpdateCartException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(path = "/{orderId}/update/{itemId}/{quantity}", method = RequestMethod.POST)
    public ResponseEntity updateItemQuantity(HttpServletRequest request,
                                             @PathVariable("orderId")  Long orderId,
                                             @PathVariable("itemId")   Long itemId,
                                             @PathVariable("quantity") Integer quantity) {
        try {
            OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
            orderItemRequestDTO.setOrderItemId(itemId);
            orderItemRequestDTO.setQuantity(quantity);
            OrderDTO response = (OrderDTO) context.getBean(OrderDTO.class.getName());
            response.wrapDetails(orderService.updateItemQuantity(orderId, orderItemRequestDTO, true), request);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (UpdateCartException | RemoveFromCartException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(path = "/{orderId}/add/promo/{promoCode}", method = RequestMethod.POST)
    public ResponseEntity addPromoToOrder(HttpServletRequest request, @PathVariable("orderId") Long orderId, @PathVariable("promoCode") String promoCode) {
        Order order = orderService.findOrderById(orderId);
        if (order == null) {
            return new ResponseEntity("No order exists for id " + orderId, HttpStatus.BAD_REQUEST);
        }
        OfferCode offerCode = offerService.lookupOfferCodeByCode(promoCode);
        if (offerCode == null) {
            return new ResponseEntity("No offerCode exists for offer code " + promoCode, HttpStatus.BAD_REQUEST);
        }
        try {
            OrderDTO response = (OrderDTO) context.getBean(OrderDTO.class.getName());
            response.wrapDetails(orderService.addOfferCode(order, offerCode, true), request);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (OfferException | PricingException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(path = "/{orderId}/remove/promo/{promoCode}", method = RequestMethod.POST)
    public ResponseEntity removePromoFromOrder(HttpServletRequest request, @PathVariable("orderId") Long orderId, @PathVariable("promoCode") String promoCode) {
        Order order = orderService.findOrderById(orderId);
        if (order == null) {
            return new ResponseEntity("No order exists for id " + orderId, HttpStatus.BAD_REQUEST);
        }
        OfferCode offerCode = offerService.lookupOfferCodeByCode(promoCode);
        if (offerCode == null) {
            return new ResponseEntity("No offerCode exists for offer code " + promoCode, HttpStatus.BAD_REQUEST);
        }
        try {
            OrderDTO response = (OrderDTO) context.getBean(OrderDTO.class.getName());
            response.wrapDetails(orderService.removeOfferCode(order, offerCode, true), request);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (PricingException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(path = "/{orderId}/add/payment", method = RequestMethod.POST)
    public ResponseEntity addPaymentToOrder(HttpServletRequest request, @PathVariable("orderId") Long orderId, @RequestBody OrderPaymentDTO orderPaymentDTO) {
        Order order = orderService.findOrderById(orderId);
        if (order == null) {
            return new ResponseEntity("No order exists for id " + orderId, HttpStatus.BAD_REQUEST);
        }
        OrderPayment payment = orderPaymentDTO.unwrap(request, context);
        payment = orderPaymentService.save(payment);
        OrderPaymentDTO response = (OrderPaymentDTO) context.getBean(OrderPaymentDTO.class.getName());
        response.wrapDetails(orderService.addPaymentToOrder(order, payment, null), request);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/{orderId}/remove/payment/{paymentId}", method = RequestMethod.POST)
    public ResponseEntity removePaymentFromOrder(HttpServletRequest request, @PathVariable("orderId") Long orderId, @PathVariable("paymentId") Long paymentId) {
        Order order = orderService.findOrderById(orderId);
        if (order == null) {
            return new ResponseEntity("No order exists for id " + orderId, HttpStatus.BAD_REQUEST);
        }
        OrderPayment payment = orderPaymentService.readPaymentById(paymentId);
        if (payment == null) {
            return new ResponseEntity("No payment exists for id " + paymentId, HttpStatus.NOT_FOUND);
        }
        orderService.removePaymentFromOrder(order, payment);
        return new ResponseEntity(order, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/{orderId}/add/address", method = RequestMethod.POST)
    public ResponseEntity addAddressToOrder(HttpServletRequest request, @PathVariable("orderId") Long orderId, @RequestBody OrderAddressDTO orderAddressDto) {
        Order order = orderService.findOrderById(orderId);
        if (order == null) {
            return new ResponseEntity("No order exists for id " + orderId, HttpStatus.BAD_REQUEST);
        }
        FulfillmentGroup shippableFulfillmentGroup = fulfillmentGroupService.getFirstShippableFulfillmentGroup(order);
        if (shippableFulfillmentGroup != null) {
            shippableFulfillmentGroup.setAddress(orderAddressDto.unwrap(request, context));
            try {
                order = orderService.save(order, true);
                return new ResponseEntity(order, HttpStatus.OK);
            } catch (PricingException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        List<OrderMultishipOption> options = orderMultishipOptionService.findOrderMultishipOptions(orderId);
        if (CollectionUtils.isNotEmpty(options)) {
            for (OrderMultishipOption option : options) {
                option.setAddress(orderAddressDto.unwrap(request, context));
                option = orderMultishipOptionService.save(option);
            }
            try {
                order = fulfillmentGroupService.matchFulfillmentGroupsToMultishipOptions(order, true);
                return new ResponseEntity(order, HttpStatus.OK);
            } catch (PricingException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity("No shippable items are in cart with id " + orderId, HttpStatus.PRECONDITION_FAILED);
    }
    
    @RequestMapping(path = "/{orderId}/remove/address/{addressId}", method = RequestMethod.POST)
    public ResponseEntity removeAddressFromOrder(HttpServletRequest request, @PathVariable("orderId") Long orderId, @PathVariable("addressId") Long addressId) {
        Order order = orderService.findOrderById(orderId);
        if (order == null) {
            return new ResponseEntity("No order exists for id " + orderId, HttpStatus.BAD_REQUEST);
        }
        List<OrderMultishipOption> options = orderMultishipOptionService.findOrderMultishipOptions(orderId);
        if (CollectionUtils.isEmpty(options)) {
            FulfillmentGroup fg = fulfillmentGroupService.getFirstShippableFulfillmentGroup(order);
            if (fg != null) {
                if (fg.getAddress() != null && fg.getAddress().equals(addressId)) {
                    fg.setAddress(null);
                    fulfillmentGroupService.save(fg);
                    return new ResponseEntity("Fulfillment group with id " + fg.getId() + " had address with id " + addressId + " removed", HttpStatus.OK);
                } else {
                    return new ResponseEntity("No shippable fulfillment group on order with id " + orderId + " has address with id " + addressId, HttpStatus.PRECONDITION_FAILED);
                }
            } else  {
                return new ResponseEntity("No shippable fulfillment group on order with id " + orderId, HttpStatus.PRECONDITION_FAILED);
            }
        }
        int count = 0;
        for (OrderMultishipOption option : options) {
            if (option.getAddress() != null && option.getAddress().getId() != null && option.getAddress().getId().equals(addressId)) {
                option.setAddress(null);
                count++;
                option = orderMultishipOptionService.save(option);
            }
        }
        return new ResponseEntity(count + " items had the address with id " + addressId + " removed", HttpStatus.OK);
    }
    
    @RequestMapping(path = "/{orderId}/split/address", method = RequestMethod.POST)
    public ResponseEntity splitOrderFulfillmentGroups(HttpServletRequest request, @PathVariable("orderId") Long orderId, @RequestBody SplitFulfillmentGroupDTO splitFulfillmentGroupDTO) {
        Order order = orderService.findOrderById(orderId);
        if (order == null) {
            return new ResponseEntity("No order exists for id " + orderId, HttpStatus.BAD_REQUEST);
        }
        List<Long> orderItemIds = splitFulfillmentGroupDTO.getOrderItemIds();
        if (splitFulfillmentGroupDTO.getOrderAddress() == null) {
            return new ResponseEntity("No address was sent to specify where the order items are suppose to be shipped to", HttpStatus.BAD_REQUEST);
        }
        OrderAddress address = splitFulfillmentGroupDTO.getOrderAddress().unwrap(request, context);
        List<OrderMultishipOption> options = orderMultishipOptionService.getOrGenerateOrderMultishipOptions(order);
        Map<Long, OrderMultishipOption> optionMap = new HashMap<>();
        for (OrderMultishipOption option : options) {
            optionMap.put(option.getOrderItem().getId(), option);
        }
        for (Long orderItemId : orderItemIds) {
            OrderMultishipOption option = optionMap.get(orderItemId);
            if (option == null) {
                return new ResponseEntity("Order item id " + orderItemId + " either doesn't exists on order with id " + orderId + " or it's no shippable", HttpStatus.BAD_REQUEST);
            }
            option.setAddress(address);
            option = orderMultishipOptionService.save(option);
        }
        try {
            order = fulfillmentGroupService.matchFulfillmentGroupsToMultishipOptions(order, true);
            return new ResponseEntity(order, HttpStatus.OK);
        } catch (PricingException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
}