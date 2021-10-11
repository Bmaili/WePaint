;(function () {

    //变量声明
    let mouseFrom = {}  //鼠标移动的起始坐标
    let mouseTo = {}//鼠标移动终点坐标
    let drawType = null
    let drawWidth =15
    let Forecolor = "#000000"; //前景色
    const Backcolor = "#000000"; //后景色
    let drawingObject = null; //当前绘制对象
    let moveCount = 1; //绘制移动计数器
    let doDrawing = false; // 绘制状态
    let move = false;//鼠标是否移动过
    const fabricHistoryJson = [];//canvas的json数组，用于前进、后腿功能
    let mods = 0;  //fabricHistoryJson[]的下标

    //初始化画板
    canvas = new fabric.Canvas('cavsElem', {
        isDrawingMode:true,
        backgroundColor: 'white',
        selectionLineWidth: 2,
        width: $("#canvasContainer").width(),
        height: $("#canvasContainer").height()
    });
    //当窗口缩放扩大时
    window.addEventListener('resize', resizeCanvas, false);

    function resizeCanvas() {
        canvas.setDimensions({
            width: $("#canvasContainer").width(),
            height: $("#canvasContainer").height()
        })
    }

    window.canvas = canvas
    window.zoom = window.zoom ? window.zoom : 1
    document.getElementById("pen").classList.add("active")
    drawType = "pen"
    fabricHistoryJson[0] = (JSON.stringify(canvas))

    // $("#sel").change(function (e) {
    //     alert("adasd");
    //     canvas.freeDrawingBrush.width =  $("#select").find("option:selected").val();//获取获取select标签选中的value值。
    // })
    //
    // //绑定画笔颜色事件
    // let aColorBtn = document.getElementsByClassName("color-item");
    // for (let i = 0; i < aColorBtn.length; i++) {
    //     aColorBtn[i].onclick = function () {
    //         for (let i = 0; i < aColorBtn.length; i++) {
    //             aColorBtn[i].classList.remove("active");
    //             this.classList.add("active");
    //             Forecolor = this.style.backgroundColor;
    //             canvas.freeDrawingBrush.color=Forecolor
    //             // canvas.freeDrawingBrush.width=document.getElementById("lineWidthBig").valueOf()
    //         }
    //     }
    // }
    //
    // let aToolBtn = document.getElementsByClassName("active-item")
    // for (let i = 0; i < aToolBtn.length; i++) {
    //     aToolBtn[i].onclick = function () {
    //         for (let i = 0; i < aToolBtn.length; i++) {
    //             aToolBtn[i].classList.remove("active");
    //             this.classList.add("active");
    //         }
    //         drawType = aToolBtn[i].id;
    //         canvas.isDrawingMode=false
    //         //初始化所有对象为不可选中
    //         var objs = canvas.getObjects();
    //         for (let obj of objs) {
    //             obj.set('selectable', false)
    //         }
    //     }
    // }
//后退
$("#pre").click(function () {
    alert('sdsdsd')
    // if (mods > 0) {
    //     mods--
    //     canvas.clear().renderAll()
    //     canvas.loadFromJSON(fabricHistoryJson[mods])
    //     canvas.renderAll()
    //     const objs = canvas.getObjects();
    //     for (let obj of objs) {
    //         obj.set('selectable', false)
    //     }
    // }
})

})()