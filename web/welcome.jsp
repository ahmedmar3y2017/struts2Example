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
    <meta charset="UTF-8">
    <!--Internet explorer-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--first Mobile Meta-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>

    <!--bootstrap stylesheet-->
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/css.css">
    <%--<!--this is my style .. This is more strong-->--%>
    <%--<link rel="stylesheet" href="css/style.css">--%>

    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>


    <![endif]-->
    <!--jquery lib-->
    <script src="js/jquery-2.0.0.js"></script>
    <!--bootstrap lib-->
    <script src="js/bootstrap.min.js"></script>
    <!--custom js file -->
    <script src="js/script.js"></script>
    <!------ Include the above in your HEAD tag ---------->
</head>
<body>

<div class="container-fluid">
    <section class="container">
        <div class="container-page">
            <div class="col-md-6">
                <h3 class="dark-grey">Tasks Form</h3>

                <form id="my_form" method="post" action="saveTask">


                    <div class="form-group col-lg-12">
                        <label>Task Name</label>
                        <input type="text" class="form-control" id="taskName" name="taskName" value="">
                    </div>

                    <div class="form-group col-lg-6">
                        <label>Begin Date</label>
                        <input type="date" name="begin" class="form-control" id="begin" value="">
                    </div>

                    <div class="form-group col-lg-6">
                        <label>End Date</label>
                        <input type="date" name="end" class="form-control" id="end" value="">
                    </div>


                    <div class="form-group col-lg-12">
                        <label>Description</label>
                        <input type="text" name="desc" class="form-control" id="desc" value="">
                    </div>
                    <div class="form-group col-lg-12">
                        <label>Manager Name</label>
                        <input type="text" name="manager_name" class="form-control" id="manager_name" value="">
                    </div>
                    <div class="col-sm-6">
                        <%--<input type="submit" name="button" id="button" class="btn btn-primary">Save Task</input>--%>

                        <button type="submit" class="btn btn-primary" name="submit">Submit Form</button>

                    </div>
                    <div id="server-results"><!-- For server results --></div>

                </form>


            </div>

            <div style="padding-top: 30px;" class="col-md-6">
                <table class="table table-hover" id="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">TaskName</th>
                        <th scope="col">Begin</th>
                        <th scope="col">End</th>
                        <th scope="col">Desc</th>
                        <th scope="col">Manager_Name</th>

                    </tr>
                    </thead>
                    <tbody>

                    </tbody>


                </table>

            </div>
        </div>
    </section>
</div>


<div id="websparrow" style="color: green; font-size: 25px;"></div>


<!-- Large modal -->
<%--<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">Large modal</button>--%>
<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-notify modal-warning" role="document">
        <!--Content-->
        <div class="modal-content">
            <!--Header-->
            <div class="modal-header text-center">
                <h4 class="modal-title white-text w-100 font-weight-bold py-2">Edit Task </h4>
                <h5 id="editMessage" class="modal-title white-text w-100 font-weight-bold py-2"> </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" class="white-text">&times;</span>
                </button>
            </div>

            <!--Body-->
            <div class="modal-body">


                <form id="my_editForm" method="post" action="updateTask">
                    <%--// hidden value for id--%>
                    <input type="hidden" id="editTaskid" name="editTaskid" value="">

                    <div class="form-group col-lg-12">
                        <label>Task Name</label>
                        <input type="text" class="form-control" id="editTaskName" name="taskName" value="">
                    </div>

                    <div class="form-group col-lg-6">
                        <label>Begin Date</label>
                        <input type="text" name="editBegin" class="form-control" id="editBegin" value="">
                    </div>

                    <div class="form-group col-lg-6">
                        <label>End Date</label>
                        <input type="text" name="editEnd" class="form-control" id="editEnd" value="">
                    </div>


                    <div class="form-group col-lg-12">
                        <label>Description</label>
                        <input type="text" name="editDesc" class="form-control" id="editDesc" value="">
                    </div>
                    <div class="form-group col-lg-12">
                        <label>Manager Name</label>
                        <input type="text" name="editManager_name" class="form-control" id="editManager_name" value="">
                    </div>
                    <div class="col-sm-6">
                        <%--<input type="submit" name="button" id="button" class="btn btn-primary">Save Task</input>--%>

                        <button type="submit" class="btn btn-outline-warning waves-effect" id="editSubmit"
                                name="submit">Edit Form <i
                                class="fa fa-paper-plane-o ml-1"></i></button>

                    </div>

                </form>


            </div>


        </div>
        <!--/.Content-->
    </div>
</div>

<%--<div class="text-center">--%>
<%--<a href="" class="btn btn-default btn-rounded" data-toggle="modal" data-target="#orangeModalSubscription">Launch--%>
<%--modal Subscription</a>--%>
<%--</div>--%>
<%--<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" id="editModal" aria-labelledby="myLargeModalLabel" aria-hidden="true">--%>
<%--<div class="modal-dialog modal-lg">--%>
<%--<div class="modal-content">--%>


<%--<form id="my_editForm" method="post" action="updateTask">--%>


<%--<div class="form-group col-lg-12">--%>
<%--<label>Task Name</label>--%>
<%--<input type="text" class="form-control" id="editTaskName" name="taskName" value="">--%>
<%--</div>--%>

<%--<div class="form-group col-lg-6">--%>
<%--<label>Begin Date</label>--%>
<%--<input type="date" name="editBegin" class="form-control" id="editBegin" value="">--%>
<%--</div>--%>

<%--<div class="form-group col-lg-6">--%>
<%--<label>End Date</label>--%>
<%--<input type="date" name="editEnd" class="form-control" id="editEnd" value="">--%>
<%--</div>--%>


<%--<div class="form-group col-lg-12">--%>
<%--<label>Description</label>--%>
<%--<input type="text" name="editDesc" class="form-control" id="editDesc" value="">--%>
<%--</div>--%>
<%--<div class="form-group col-lg-12">--%>
<%--<label>Manager Name</label>--%>
<%--<input type="text" name="editManager_name" class="form-control" id="editManager_name" value="">--%>
<%--</div>--%>
<%--<div class="col-sm-6">--%>
<%--&lt;%&ndash;<input type="submit" name="button" id="button" class="btn btn-primary">Save Task</input>&ndash;%&gt;--%>

<%--<button type="submit" class="btn btn-primary" name="submit">Edit Form</button>--%>

<%--</div>--%>

<%--</form>--%>


<%--</div>--%>
<%--</div>--%>
<%--</div>--%>


</body>
</html>
