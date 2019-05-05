<%--
  Created by IntelliJ IDEA.
  User: pandi
  Date: 5/3/2019
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="error.jsp"%>

<%@include file="header.jsp"%>
<html>
<head>

    <title>Ingredient</title>
</head>
<body>
        <h2>In Ingredient page</h2>

        <form>


            <div class="container">
                <div class="Main Ingredient">
                    <select class="second-level-select">
                        <option value="">-Select Main Ingredient-</option>
                        <option value="Meat">Meat</option>
                        <option value="Cereal">Cereal</option>
                    </select>
                </div>
            </div>

                <div class="container">
                    <div class="Side Ingredient">
                        <select class="second-level-select">
                            <option value="">-Select Side Ingredient-</option>
                            <option value="Spices">Spices</option>
                            <option value="Masala">Masala</option>
                        </select>
                    </div>
                </div>




        <input type="submit" value="Submit">
        </form>

</body>
</html>
