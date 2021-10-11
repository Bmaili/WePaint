$(function () {
    //变量声明
    let mouseFrom = {}  //鼠标移动的起始坐标
    let mouseTo = {}//鼠标移动终点坐标
    let drawType = null
    let drawWidth = 15
    let Forecolor = "#000000"; //前景色
    let Backcolor = "#000000"; //后景色
    let color_module = "forecolor";
    let drawingObject = null; //当前绘制对象
    let moveCount = 1; //绘制移动计数器
    let doDrawing = false; // 绘制状态
    let move = false;//鼠标是否移动过
    const fabricHistoryJson = [];//canvas的json数组，用于前进、后腿功能
    let mods = 0;  //fabricHistoryJson[]的下标


    //初始化画板，及设置
    canvas = new fabric.Canvas('cavsElem', {
        isDrawingMode: true,
        backgroundColor: 'white',
        selectionLineWidth: 2,
    });
    window.canvas = canvas
    window.zoom = window.zoom ? window.zoom : 1
    document.getElementById("pen").classList.add("active");
    document.getElementById("forecolor").classList.add("active")
    drawType = "pen";
    fabricHistoryJson[0] = (JSON.stringify(canvas));


    //绑定画笔颜色事件
    let aColorBtn = $(".colorchose");
    for (let i = 0; i < aColorBtn.length; i++) {
        aColorBtn[i].onclick = function () {
            document.getElementById(color_module).style.backgroundColor = this.style.backgroundColor;
            Forecolor = document.getElementById("forecolor").style.backgroundColor;
            Backcolor = document.getElementById("backcolor").style.backgroundColor;
            canvas.freeDrawingBrush.color = Forecolor;
        }
    }
    document.querySelector("#anycolor").onchange = function () {
        $("#anycolor").click();
        document.getElementById(color_module).style.backgroundColor = this.value;
        Forecolor = document.getElementById("forecolor").style.backgroundColor;
        Backcolor = document.getElementById("backcolor").style.backgroundColor;
        canvas.freeDrawingBrush.color = Forecolor;

    };

    //绑定按钮事件
    let longclickBtn = $(".long_click");
    for (let i = 0; i < longclickBtn.length; i++) {
        longclickBtn[i].onclick = function () {
            //更改选中按钮的颜色效果
            for (let i = 0; i < longclickBtn.length; i++) {
                longclickBtn[i].classList.remove("active");
                this.classList.add("active");
            }
            drawType = longclickBtn[i].id;
            canvas.isDrawingMode = false
            //初始化所有对象为不可选中
            const objs = canvas.getObjects();
            for (let obj of objs) {
                obj.set('selectable', false)
            }
        }
    }

    $("#forecolor").click(function () {
        $("#backcolor")[0].classList.remove("active");
        $("#forecolor")[0].classList.add("active");
        color_module = "forecolor";
    })
    $("#backcolor").click(function () {
        $("#forecolor")[0].classList.remove("active");
        $("#backcolor")[0].classList.add("active");
        color_module = "backcolor";

    })
    //前进
    $("#next").click(function () {
        if (mods + 1 < fabricHistoryJson.length) {
            mods++
            canvas.clear().renderAll()
            canvas.loadFromJSON(fabricHistoryJson[mods])
            canvas.renderAll()
            const objs = canvas.getObjects();
            for (let obj of objs) {
                obj.set('selectable', false)
            }
        }
    })

    //后退
    $("#pre").click(function () {
        if (mods > 0) {
            mods--
            canvas.clear().renderAll()
            canvas.loadFromJSON(fabricHistoryJson[mods])
            canvas.renderAll()
            const objs = canvas.getObjects();
            for (let obj of objs) {
                obj.set('selectable', false)
            }
        }
    })

    //清空
    $("#clear").click(function () {
        canvas.clear().renderAll()
        canvas.loadFromJSON(fabricHistoryJson[0])
        mods++;//步数加1
        fabricHistoryJson[mods] = (JSON.stringify(canvas))
        fabricHistoryJson.splice(mods + 1)
    })

    //选择
    $("#select").click(function () {
        var objs = canvas.getObjects();
        for (let obj of objs) {
            obj.set('selectable', true)
        }
    })

    //笔刷
    $("#pen").click(function () {
        canvas.isDrawingMode = true
        canvas.freeDrawingBrush.color = Forecolor
        canvas.freeDrawingBrush.width = 20
    })

    //橡皮
    $("#eraser").click(function () {
        canvas.isDrawingMode = true
        canvas.freeDrawingBrush.color = "#fff" //画笔设置为背景色
        canvas.freeDrawingBrush.width = 30
    })

    //文本
    $("#text").click(function () {
        var Text = new fabric.Text("Hello World", {
            color: Forecolor,
            fontStyle: 'italic',
            fontFamily: 'Hoefler Text'
        });
        canvas.add(Text);
    })

    //url图片
    $("#picture").click(function () {
        fabric.Image.fromURL($('#picture_url').val(), function (oImg) {
            canvas.add(oImg);
        });
    })


    //画板鼠标按下事件
    canvas.on("mouse:down", function (options) {
        let xy;
        if (!options.pointer.x) {
            xy = transformMouse(options.e.offsetX, options.e.offsetY);
        } else {
            xy = transformMouse(options.pointer.x, options.pointer.y);
        }
        mouseFrom.x = xy.x
        mouseFrom.y = xy.y
        doDrawing = true
        move = false

    })

    //画板鼠标抬起事件
    canvas.on("mouse:up", function (options) {
        drawingObject = null
        moveCount = 1
        doDrawing = false
        if (move) {
            mods++;//步数加1
            fabricHistoryJson[mods] = (JSON.stringify(canvas))
            fabricHistoryJson.splice(mods + 1)
        }
    })

    //画板鼠标移动事件
    canvas.on("mouse:move", function (options) {
        //减少绘制频率
        if (moveCount % 2 && !doDrawing) {
            return
        }
        moveCount++
        move = true
        let xy;
        if (!options.pointer.x) {
            xy = transformMouse(options.e.offsetX, options.e.offsetY);
        } else {
            xy = transformMouse(options.pointer.x, options.pointer.y);
        }
        mouseTo.x = xy.x
        mouseTo.y = xy.y
        var dataTo = {
            drawType: drawType,
            mouseFromX: mouseFrom.x,
            mouseFromY: mouseFrom.y,
            mouseToX: mouseTo.x,
            mouseToY: mouseTo.y,
        }
        drawing()
    })


//坐标转换
    function transformMouse(mouseX, mouseY) {
        return {x: mouseX / window.zoom, y: mouseY / window.zoom}
    }

//绘画方法
    function drawing() {
        if (drawingObject) {
            canvas.remove(drawingObject)
        }
        var canvasObject = null
        switch (drawType) {
            case "arrow": //箭头
                canvasObject = new fabric.Path(
                    drawArrow(mouseFrom.x, mouseFrom.y, mouseTo.x, mouseTo.y, 30, 30),
                    {
                        stroke: Forecolor,
                        fill: "rgba(255,255,255,0)",
                        strokeWidth: drawWidth,
                    }
                )
                break
            case "line": //直线
                canvasObject = new fabric.Line(
                    [mouseFrom.x, mouseFrom.y, mouseTo.x, mouseTo.y],
                    {
                        stroke: Forecolor,
                        strokeWidth: drawWidth,
                    }
                )
                break
            case "dottedline": //虚线
                canvasObject = new fabric.Line(
                    [mouseFrom.x, mouseFrom.y, mouseTo.x, mouseTo.y],
                    {
                        strokeDashArray: [3, 1],
                        stroke: Forecolor,
                        strokeWidth: drawWidth,
                    }
                )
                break
            case "circle": //正圆
                var left = mouseFrom.x,
                    top = mouseFrom.y
                var radius =
                    Math.sqrt(
                        (mouseTo.x - left) * (mouseTo.x - left) +
                        (mouseTo.y - top) * (mouseTo.y - top)
                    ) / 2
                canvasObject = new fabric.Circle({
                    left: left,
                    top: top,
                    stroke: Forecolor,
                    fill: "rgba(255, 255, 255, 0)",
                    radius: radius,
                    strokeWidth: drawWidth,
                })
                break
            case "ellipse": //椭圆
                var left = mouseFrom.x,
                    top = mouseFrom.y
                var radius =
                    Math.sqrt(
                        (mouseTo.x - left) * (mouseTo.x - left) +
                        (mouseTo.y - top) * (mouseTo.y - top)
                    ) / 2
                canvasObject = new fabric.Ellipse({
                    left: left,
                    top: top,
                    stroke: Forecolor,
                    fill: "rgba(255, 255, 255, 0)",
                    originX: "center",
                    originY: "center",
                    rx: Math.abs(left - mouseTo.x),
                    ry: Math.abs(top - mouseTo.y),
                    strokeWidth: drawWidth,
                })
                break
            case "square": //TODO:正方形
                break
            case "rectangle": //长方形
                var path =
                    "M " +
                    mouseFrom.x +
                    " " +
                    mouseFrom.y +
                    " L " +
                    mouseTo.x +
                    " " +
                    mouseFrom.y +
                    " L " +
                    mouseTo.x +
                    " " +
                    mouseTo.y +
                    " L " +
                    mouseFrom.x +
                    " " +
                    mouseTo.y +
                    " L " +
                    mouseFrom.x +
                    " " +
                    mouseFrom.y +
                    " z"
                canvasObject = new fabric.Path(path, {
                    left: left,
                    top: top,
                    stroke: Forecolor,
                    strokeWidth: drawWidth,
                    fill: "rgba(255, 255, 255, 0)",
                })
                //也可以使用fabric.Rect
                break
            case "rightangle": //直角三角形
                var path =
                    "M " +
                    mouseFrom.x +
                    " " +
                    mouseFrom.y +
                    " L " +
                    mouseFrom.x +
                    " " +
                    mouseTo.y +
                    " L " +
                    mouseTo.x +
                    " " +
                    mouseTo.y +
                    " z"
                canvasObject = new fabric.Path(path, {
                    left: left,
                    top: top,
                    stroke: Forecolor,
                    strokeWidth: drawWidth,
                    fill: "rgba(255, 255, 255, 0)",
                })
                break
            case "equilateral": //等边三角形
                var height = mouseTo.y - mouseFrom.y
                canvasObject = new fabric.Triangle({
                    top: mouseFrom.y,
                    left: mouseFrom.x,
                    width: Math.sqrt(Math.pow(height, 2) + Math.pow(height / 2.0, 2)),
                    height: height,
                    stroke: Forecolor,
                    strokeWidth: drawWidth,
                    fill: "rgba(255,255,255,0)",
                })
                break

            default:
                break
        }
        if (canvasObject) {
            // canvasObject.index = getCanvasObjectIndex();
            canvas.add(canvasObject) //.setActiveObject(canvasObject)
            drawingObject = canvasObject
        }
        canvasObject.set('selectable', false);//刚创建的对象默认不可选中
    }


    //绘制箭头方法
    function drawArrow(fromX, fromY, toX, toY, theta, headlen) {
        theta = typeof theta != "undefined" ? theta : 30
        headlen = typeof theta != "undefined" ? headlen : 10
        // 计算各角度和对应的P2,P3坐标
        var angle = (Math.atan2(fromY - toY, fromX - toX) * 180) / Math.PI,
            angle1 = ((angle + theta) * Math.PI) / 180,
            angle2 = ((angle - theta) * Math.PI) / 180,
            topX = headlen * Math.cos(angle1),
            topY = headlen * Math.sin(angle1),
            botX = headlen * Math.cos(angle2),
            botY = headlen * Math.sin(angle2)
        var arrowX = fromX - topX,
            arrowY = fromY - topY
        var path = " M " + fromX + " " + fromY
        path += " L " + toX + " " + toY
        arrowX = toX + topX
        arrowY = toY + topY
        path += " M " + arrowX + " " + arrowY
        path += " L " + toX + " " + toY
        arrowX = toX + botX
        arrowY = toY + botY
        path += " L " + arrowX + " " + arrowY
        return path
    }

    $("#download").click(function () {
        let imgUrl = document.getElementById("cavsElem").toDataURL("image/png");
        let saveA = document.createElement("a");
        document.body.appendChild(saveA);
        saveA.href = imgUrl;
        saveA.download = "WePaintpic" + (new Date).getTime();
        saveA.target = "_blank";
        saveA.click();
    })

})