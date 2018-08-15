<%@page import="entity.Cart"%>
<%@page import="java.util.Map"%>
<%@page import="entity.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <link href="css/cart.css" rel="stylesheet">

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
<!--        <script src="js/cart.js"></script>-->
    </head>
    <body>  
                
          <%                       
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
        %>
        <%@include file="header.jsp" %>   
        
        <div class="container">
            <div class="shopping-cart">
                <div class="column-labels">
                    <label class="product-image">Image</label>
                    <label class="product-details">Product</label>
                    <label class="product-price">Price</label>
                    <label class="product-quantity">Quantity</label>
                    <label class="product-removal">Remove</label>
                    <label class="product-line-price">Total</label>
                </div>
                <%int count=0; %>
                <% for (Map.Entry<String, Item> list : cart.getCartItems().entrySet()) {%>
                <%count++;%>
                <div class="product">
                    <div class="product-image">
                        <img src="<%=list.getValue().getProduct().getImage()%>" alt=""/>
                    </div>
                    <div class="product-details">
                        <div class="product-title"><%=list.getValue().getProduct().getProductName()%></div>
                        <p class="product-description"><%= list.getValue().getProduct().getDescription()%></p>
                    </div>
                        <div class="product-price"><%=list.getValue().getProduct().getPrice()%></div>
                    <div class="product-quantity">
                        <input id="<%=count%>" type="number"
                               value="<%=list.getValue().getQuantity()%>"
                               min="1"/>
                    </div>      

                    <div class="product-removal">
                        <button class="remove-product">
                            Remove
                        </button>
                    </div>
                    <div class="product-line-price"><%=list.getValue().getProduct().getPrice()%></div>
                </div>               
                <%}%>
                <div class="totals">
                    <div class="totals-item">
                        <label>Subtotal</label>
                        <div class="totals-value" id="cart-subtotal">
                            </div>    
                    </div>
                    <div class="totals-item">
                        <label>Tax (10%)</label>
                        <div class="totals-value" id="cart-tax"></div>
                    </div>
                    <div class="totals-item">
                        <label>Shipping</label>
                        <div class="totals-value" id="cart-shipping">5.00</div>
                    </div>
                    <div class="totals-item totals-item-total">
                        <label>Grand Total</label>
                        <div class="totals-value" id="cart-total">                           
                            
                        </div>
                    </div>
                </div>
                <a href="checkout.jsp"><button class="checkout" type="submit">Check Out</button></a>
            </div>
                
        </div>
        <%@include file="footer.jsp" %>
     
    </body>
</html>
