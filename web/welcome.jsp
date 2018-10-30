<%--
  Created by IntelliJ IDEA.
  User: ahmed.marey
  Date: 10/29/2018
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
    <title>Tasks</title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
</head>
<body>

<div class="container-fluid">
    <section class="container">
        <div class="container-page">
            <div class="col-md-6">
                <h3 class="dark-grey">Tasks Form</h3>

                <div class="form-group col-lg-12">
                    <label>Task Name</label>
                    <input type="" name="" class="form-control" id="" value="">
                </div>

                <div class="form-group col-lg-6">
                    <label>Begin Date</label>
                    <input type="date" name="" class="form-control" id="" value="">
                </div>

                <div class="form-group col-lg-6">
                    <label>End Date</label>
                    <input type="date" name="" class="form-control" id="" value="">
                </div>


                <div class="form-group col-lg-12">
                    <label>Description</label>
                    <input type="" name="" class="form-control" id="" value="">
                </div>
                <div class="form-group col-lg-12">
                    <label>Manager Name</label>
                    <input type="" name="" class="form-control" id="" value="">
                </div>
                <div class="col-sm-6">
                    <button type="submit" class="btn btn-primary">Save Task</button>
                </div>


            </div>

            <div style="padding-top: 30px;" class="col-md-6">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">First</th>
                        <th scope="col">Last</th>
                        <th scope="col">Handle</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                        <td>
                            <button type="button" class="btn btn-default">Edit</button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-danger">Delete</button>
                        </td>
                    </tr>

                    </tbody>
                    <s:property value="user.email"></s:property>

                    <s:iterator  var="i" step="1" value="tasks">
                        <s:property value="i.name"></s:property>
                    </s:iterator>








                </table>
            </div>
        </div>
    </section>
</div>


</body>
</html>
