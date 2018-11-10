$(document).ready(function () {
    console.log("Done Load Event ")

// display All Tasks With ajax
    DisplayAllTasks(false);

    $("#my_editForm").submit(function (event) {

        event.preventDefault(); //prevent default action
        var post_url = $(this).attr("action"); //get form action url
        var request_method = $(this).attr("method"); //get form GET/POST method


        var editTaskid = $('#editTaskid').val();
        var editTaskName = $('#editTaskName').val();
        var editBegin = $('#editBegin').val();
        var editEnd = $('#editEnd').val();
        var editDesc = $('#editDesc').val();
        var editManager_name = $('#editManager_name').val();


        console.log("Id Is : " + editTaskid)
        // make ajax request to update
        UpdateSpecificTask(editTaskid, editTaskName, editBegin, editEnd, editDesc, editManager_name)

    });


    $("#my_form").submit(function (event) {

        event.preventDefault(); //prevent default action
        var post_url = $(this).attr("action"); //get form action url
        var request_method = $(this).attr("method"); //get form GET/POST method

        var taskName = $('#taskName').val();
        var begin = $('#begin').val();
        var end = $('#end').val();
        var desc = $('#desc').val();
        var manager_name = $('#manager_name').val();


        SaveSpecificTask(taskName, begin, end, desc, manager_name);

    });

    function DisplayAllTasks(updated) {

        if (updated == true) {
            // delete all table rows
            $("#table").find("tr:gt(0)").remove();


        }

        //Perform Ajax request to display all tasks When load Page .
        $.ajax({
            url: 'getmydata',
            type: 'get',
            success: function (data) {
                //If the success function is execute,
                //then the Ajax request was successful.
                //Add the data we received in our Ajax
                //request to the "content" div.
                // $('#content').html(data);
                console.log(data);
                var table = $('#table');

                $.each(data.dataList, function () {
                    var id = this.id;
                    var taskName = this.taskName;
                    var begin = this.begin;
                    var end = this.end;
                    var desc = this.desc;
                    var manager_name = this.manager_name;

                    var td;
                    var tr = document.createElement('tr');

                    td = document.createElement('td');
                    td.innerHTML = this.id;
                    // set id to row
                    tr.id = this.id;
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = this.taskName;
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = this.begin;
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = this.end;
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = this.desc;
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = this.manager_name;
                    tr.appendChild(td);

                    td = document.createElement('td');


                    // td.innerHTML = " <button type=\"button\" class=\"btn btn-default\" >Edit</button>";
                    var editButton = document.createElement('button');
                    // deleteButton.id=this.id
                    editButton.type = "button"
                    editButton.innerHTML = "Edit " + this.id
                    editButton.classList.add("btn");
                    editButton.classList.add("btn-default");
                    editButton.addEventListener('click', function () {
                        // do ajax to delete This Row From Database And Design
                        console.log("Edit " + begin)


                        // open modal
                        $('#editModal').modal('toggle')
                        // set values to Fields

                        $('#editTaskid').val(id);
                        $('#editTaskName').val(taskName);
                        $('#editBegin').val(begin);
                        $('#editEnd').val(end);
                        $('#editDesc').val(desc);
                        $('#editManager_name').val(manager_name);


                    });

                    td.appendChild(editButton);
                    tr.appendChild(td);

                    td = document.createElement('td');
                    // td.innerHTML = " <button type=\"button\" class=\"btn btn-danger\" onclick='DeleteSpecificTask(this.id)'>Delete</button>";
                    var deleteButton = document.createElement('button');
                    // deleteButton.id=this.id
                    deleteButton.type = "button"
                    deleteButton.innerHTML = "Delete " + this.id
                    deleteButton.classList.add("btn");
                    deleteButton.classList.add("btn-danger");
                    deleteButton.addEventListener('click', function () {
                        // do ajax to delete This Row From Database And Design
                        DeleteSpecificTask(id);

                    });

                    td.appendChild(deleteButton);

                    tr.appendChild(td);
                    table.append(tr);
                });

            },
            error: function (xhr, ajaxOptions, thrownError) {
                var errorMsg = 'Ajax request failed: ' + xhr.responseText;
                // $('#content').html(errorMsg);
                console.log(errorMsg);

            }
        });


    }

    function UpdateSpecificTask(id, taskName, begin, end, desc, manager_name) {

        // ajax delete from database
        $.ajax({
            type: 'POST',
            url: 'updateTask',
            data: 'id=' + id + '&taskName=' + taskName + '&begin=' + begin + '&end=' + end + '&desc=' + desc + '&manager_name=' + manager_name,
            success: function (data) {
                //confirmation of deletion
                // delete from design also
                $('#editMessage').val(data.message);
                // call ajax all tasks again .
                DisplayAllTasks(true);

            }
        });
        console.log("Id is : " + id);


    }

    function SaveSpecificTask(taskName, begin, end, desc, manager_name) {

        // ajax save to database
        $.ajax({
            type: 'POST',
            url: 'saveTask',
            data: 'taskName=' + taskName + '&begin=' + begin + '&end=' + end + '&desc=' + desc + '&manager_name=' + manager_name,
            success: function (data) {
                //confirmation of deletion
                // delete from design also
                // $('#editMessage').val();
                console.log(data.task.message);

                // // call ajax all tasks again .
                // DisplayAllTasks(true);

                var td;
                var tr = document.createElement('tr');

                td = document.createElement('td');
                td.innerHTML = data.task.id;
                // set id to row
                tr.id = data.task.id;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = data.task.taskName;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = data.task.begin;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = data.task.end;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = data.task.desc;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = data.task.manager_name;
                tr.appendChild(td);

                td = document.createElement('td');


                // td.innerHTML = " <button type=\"button\" class=\"btn btn-default\" >Edit</button>";
                var editButton = document.createElement('button');
                // deleteButton.id=this.id
                editButton.type = "button"
                editButton.innerHTML = "Edit " + data.task.id
                editButton.classList.add("btn");
                editButton.classList.add("btn-default");
                editButton.addEventListener('click', function () {
                    // do ajax to delete This Row From Database And Design
                    console.log("Edit " + data.task.begin)


                    // open modal
                    $('#editModal').modal('toggle')
                    // set values to Fields

                    $('#editTaskid').val(data.task.id);
                    $('#editTaskName').val(data.task.taskName);
                    $('#editBegin').val(data.task.begin);
                    $('#editEnd').val(data.task.end);
                    $('#editDesc').val(data.task.desc);
                    $('#editManager_name').val(data.task.manager_name);


                });

                td.appendChild(editButton);
                tr.appendChild(td);

                td = document.createElement('td');
                // td.innerHTML = " <button type=\"button\" class=\"btn btn-danger\" onclick='DeleteSpecificTask(this.id)'>Delete</button>";
                var deleteButton = document.createElement('button');
                // deleteButton.id=this.id
                deleteButton.type = "button"
                deleteButton.innerHTML = "Delete " + data.task.id
                deleteButton.classList.add("btn");
                deleteButton.classList.add("btn-danger");
                deleteButton.addEventListener('click', function () {
                    // do ajax to delete This Row From Database And Design
                    DeleteSpecificTask(data.task.id);

                });

                td.appendChild(deleteButton);

                tr.appendChild(td);
                table.append(tr);


            }
        });


    }


    function DeleteSpecificTask(id) {

        // ajax delete from database
        $.ajax({
            type: 'POST',
            url: 'deleteTask',
            data: 'id=' + id,
            success: function (data) {
                //confirmation of deletion
                // delete from design also

                var row = document.getElementById(id);
                var table = row.parentNode;
                while (table && table.tagName != 'TABLE')
                    table = table.parentNode;
                if (!table)
                    return;
                table.deleteRow(row.rowIndex);

            }
        });
        console.log("Id is : " + id);


    }


});