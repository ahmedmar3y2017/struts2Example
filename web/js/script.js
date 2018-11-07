$(document).ready(function () {
    console.log("Done Load Event ")

// display All Tasks With ajax
    DisplayAllTasks();

    $("#my_form").submit(function (event) {
        console.log("Done Action");

        event.preventDefault(); //prevent default action
        var post_url = $(this).attr("action"); //get form action url
        var request_method = $(this).attr("method"); //get form GET/POST method

        var taskName = $('#taskName').val();
        var begin = $('#begin').val();
        var end = $('#end').val();
        var desc = $('#desc').val();
        var manager_name = $('#manager_name').val();


        var task = {
            "task": {
                "taskName": taskName,
                "begin": begin,
                "end": end,
                "desc": desc,
                "manager_name": manager_name
            }
        };


        console.log(task);

        $.ajax({
            url: 'saveTask',
            type: 'POST',
            data: task,
            success: function (data) { //
                console.log(data);

            },
            error: function (xhr, ajaxOptions, thrownError) {
                var errorMsg = 'Ajax request failed: ' + xhr.responseText;
                // $('#content').html(errorMsg);
                console.log(errorMsg);

            }
        });

    });

    function DisplayAllTasks() {

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
                        console.log("Edit ")


                        // open modal
                        $('#editModal').modal('toggle')
                        // set values to Fields
                        $('#editTaskName').val(taskName);
                        $('#editBegin').val(new Date(begin));
                        $('#editEnd').val(new Date(end));
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