<%--
  Created by IntelliJ IDEA.
  User: pandi
  Date: 5/3/2019
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="error.jsp" %>

<%@include file="header.jsp"%>

<html>
<head>
    <title>Food</title>
</head>
<body>
        <h2>In food page</h2>

        <form>


            <div class="container">
                <div class="Main Course">
                    <select class="second-level-select">
                        <option value="">-Select Main Course-</option>
                        <option value="Dry Dish">Dry Dish</option>
                        <option value="Gravy Dish">Gravy Dish</option>
                    </select>
                </div>
            </div>

            <div class="container">
                <div class="Side Dish">
                    <select class="second-level-select">
                        <option value="">-Select Side Dish-</option>
                        <option value="Fried Side Dish">Fried Side Dish</option>
                        <option value="Steamed Side Dish">Steamed Side Dish</option>
                        <option value="Sauteed Side Dish">Sauteed Side Dish</option>
                    </select>
                </div>
            </div>




            <input type="submit" value="Submit">
        </form>

</body>
</html>
