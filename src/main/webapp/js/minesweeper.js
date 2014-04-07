function doAjaxPost() {
    // get the form values
    var name = $('#name').val();
    var education = $('#education').val();

    $.ajax({
        type: "POST",
        url: "/AjaxWithSpringMVC2Annotations/AddUser.htm",
        data: "name=" + name + "&education=" + education,
        success: function(response){
            // we have the response
                $('#info').html(response);
                $('#name').val('');
                $('#education').val('');
        },
        error: function(e){
            alert('Error: ' + e);
        }
    });
}