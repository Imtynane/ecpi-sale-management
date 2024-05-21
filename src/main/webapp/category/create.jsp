<%--
  Created by IntelliJ IDEA.
  User: Imtynane
  Date: 07/05/2024
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tg:confirm-delete-modal/>
<tg:template title="Ajouter une catégorie">
    <jsp:attribute name="content">
        <div class="row p-4">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <div class="row">
                            <div class="col-10 mt-2">
                                <h3 class="card-title">Ajouter une nouvelle categorie</h3>
                            </div>
                            <div class="col-2">
                                <a type="button" class="btn float-right btn-primary"
                                   href="${pageContext.request.contextPath}/category/create"> <i
                                        class="fa fa-plus">
                                   </i>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">

                        <form method="post" action="${pageContext.request.contextPath}//category/create">
                          <div class="row">
                             <div class="col-12">
                                 <label for="name">Name</label>
                                 <input type="text" name="name" id="name"/>
                             </div>
                              <div class="col-12">
                                  <label for="name">Description</label>
                                  <input type="text" name="description" id="description"/>
                              </div>
                              <div class="col-12">
                                  <button type="submit" class="btn btn-success">Créer</button>
                              </div>
                          </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </jsp:attribute>
</tg:template>