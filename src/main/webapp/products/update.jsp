<%--
  Created by IntelliJ IDEA.
  User: Imtynane
  Date: 26/05/2024
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<tg:template title="Edit product">
    <jsp:attribute name="content">
        <form method="post" action="${pageContext.request.contextPath}/products/update?id=${category.id}">
            <div class="row p-4">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <div class="float-left">
                                <div class="btn-group">
                                    <a href="${pageContext.request.contextPath}/products" class="btn btn-sm btn-block btn-secondary"><i class="fas fa-arrow-left"></i>
                                    </a>
                                </div>
                            </div>
                            <span class="card-title pl-2">Create product</span>

                            <div class="row float-right">
                                <div class="btn-group">
                                    <button type="submit" class="btn btn-success mr-2" id="form-btn"><i class="fas fa-save"></i></button>
                                    <a type="button" class="btn btn-danger" href="${pageContext.request.contextPath}/products"><i class="fas fa-times"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-12">
                                    <label  class="col-form-label">Name</label>
                                    <input value="${product.name}"  type="text" required class="form-control" name='name'  placeholder="Name" />
                                </div>

                                <div class="col-12">
                                    <label class="col-form-label">Description</label>
                                    <input value="${product.description}"  type="text" required class="form-control" name='description'  placeholder="Description" />
                                </div>

                                <div class="col-12">
                                    <label class="col-form-label">Price</label>
                                    <input value="${product.price}"  type="text" required class="form-control" name='price'  placeholder="Price" />
                                </div>

                                <div class="col-12">
                                    <label class="col-form-label">Category</label>
                                    <input value="${product.category}"  type="text" required class="form-control" name='category'  placeholder="Category" />
                                </div>

                                <div class="col-12">
                                    <label class="col-form-label">Quantity</label>
                                    <input value="${product.quantity}"  type="text" required class="form-control" name='quantity'  placeholder="quantity" />
                                </div>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </form>
    </jsp:attribute>
</tg:template>
