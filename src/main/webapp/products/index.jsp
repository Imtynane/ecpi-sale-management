<%--
  Created by IntelliJ IDEA.
  User: Imtynane
  Date: 26/05/2024
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tg:confirm-delete-modal/>
<tg:template title="Products">
    <jsp:attribute name="content">
        <div class="row p-4">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <div class="row">
                            <div class="col-10 mt-2">
                                <h3 class="card-title">Products</h3>
                            </div>
                            <div class="col-2">
                                <a type="button" class="btn float-right btn-primary"
                                   href="${pageContext.request.contextPath}/products/create"> <i
                                        class="fa fa-plus"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">

                        <div class="d-flex justify-content-between p-2">
                            <div>
                                <select name="size" class="form-control">
                                    <option value="5">5</option>
                                    <option value="10">10</option>
                                    <option value="20">20</option>
                                </select>
                            </div>
                            <div>
                                <input type="text" name="param" id="param" class="form-control col-12 float-right"
                                       placeholder="Search..."/>
                            </div>
                        </div>

                        <c:if test="${message!=null}">
                            <div class="alert alert-success alert-dismissible fade show" role="alert">
                                <p>${message}</p>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </c:if>

                        <table class="table table-bordered table-striped">
                            <thead>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Category</th>
                            <th>Quantity</th>
                            <th>Actions</th>
                            </thead>
                            <tbody>

                            </tr>

                            <c:forEach var="p" items="${product}">

                            <tr>
                                <td>${p.id}</td>
                                <td>${p.name}</td>
                                <td>${p.description}</td>
                                <td>${p.price}</td>
                                <td>${p.category}</td>
                                <td>${p.quantity}</td>

                                <td>
                                    <a class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/products/update?id=${p.id}"><i class='fas fa-pen'></i></a>
                                    <button class="btn btn-danger btn-sm" onclick="showDeleteModal('${pageContext.request.contextPath}/products/delete?id='+${p.id})"><i class='fas fa-trash'></i></button>
                                </td>
                            </tr>
                             </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </jsp:attribute>
</tg:template>
