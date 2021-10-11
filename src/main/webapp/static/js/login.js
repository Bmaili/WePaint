$(function () {
    // $("#to_login_btn").click(function (e) {
    //     $(".regist_div").hide();
    //     $(".login_div").show();
    //     e.preventDefault();
    // });
    // $("#to_regist_btn").click(function (e) {
    //     $(".login_div").hide();
    //     $(".regist_div").show();
    //     e.preventDefault();
    // });
    const canvas = new fabric.Canvas('cavsElem', {isDrawingMode: true});
    canvas.setBackgroundColor("#fff");

    const welcomeText = new fabric.Text("Welcome to WePaint!", {
        fontFamily: 'Comic Sans',
        fontSize: 40,
        stroke: '#ffcccc',
        shadow: 'green -5px -5px 3px',
        textAlign: 'right',
        left: 10, top: 80, angle: -10
    });
    canvas.add(welcomeText);

    var welcomeText2 = new fabric.Text('Sign in,\npainting with friends!', {
        textAlign: 'right',
        fontStyle: 'italic',
        fontFamily: 'Hoefler Text',
        fontSize: 20,
        stroke: '#D965E3',
        textAlign: 'right',
        left: 500, top: 30, angle: 20
    });
    canvas.add(welcomeText2);


    fabric.Image.fromURL('../../static/img/luodi.png', function (oImg) {
        oImg.set({left: -540, top: 80, angle: -10});
        canvas.add(oImg);
    });


})