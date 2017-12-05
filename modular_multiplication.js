var radius
var nslider
var mslider

function setup () {
	
	createCanvas(windowWidth, windowHeight)
	background(50,50,50)
	textSize(20)
	fill(255,255,100)
	stroke(255,255,100)

	radius = min(windowWidth, windowHeight)*2/5

	nslider = createSlider(1, 500, 10, 1)
	nslider.position(20, 20)
	mslider = createSlider(1, 250, 2, 1)
	mslider.position(20, 50)

	text("number of points", nslider.x * 2 + nslider.width, 35)
	text("multiplier", mslider.x * 2 + mslider.width, 65)

}

function draw () {

	var n = nslider.value()
	var m = mslider.value()


	
	background(50,50,50)
	text("number of points", nslider.x * 2 + nslider.width, 35)
	text("multiplier", mslider.x * 2 + mslider.width, 65)

	fill(255, 0, 0)
	stroke(255, 0, 0)
	for (var i = 0; i < n; i++) {
		var angle = 5/2 * PI - 2 * PI * i / n
		if (angle > 2 * PI)
			angle -= 2 * PI
		ellipse(windowWidth/2 + radius * cos(angle), windowHeight/2 - radius * sin(angle), 5, 5)
	}

	for (var i = 0; i < n; i++) {
		var ang1 = 5/2 * PI - 2 * PI / n * i
		var ang2 = 5/2 * PI - 2 * PI / n * ((m * i) % n)
		if (ang1 > 2 * PI)
			ang1 -= 2 * PI
		if (ang2 > 2 * PI)
			ang2 -= 2 * PI
		var x1 = windowWidth/2 + radius * cos(ang1)
		var x2 = windowWidth/2 + radius * cos(ang2)
		var y1 = windowHeight/2 - radius * sin(ang1)
		var y2 = windowHeight/2 - radius * sin(ang2)
		fill(255, 255, 100)
		stroke(255, 255, 100)
		strokeWeight(1)
		line(x1, y1, x2, y2)
	}

}