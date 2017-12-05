var a, b, c, two
var angA, angB, angC
var x_a, x_b, x_c, y_a, y_b, y_c
var fullArea, halfArea
var lineSlider
var nextButton, resetButton
var scale

function setup() {
  	
	createCanvas(windowWidth, windowHeight)
	background(50,50,50)

	lineSlider = createSlider(0,1/2,0,.001)
	lineSlider.position(20,20)

	nextButton = createButton("next")
	nextButton.position(20, 50)
	nextButton.mousePressed(nextTriangle)

	resetButton = createButton("reset")
	resetButton.position(80, 50)
	resetButton.mousePressed(reset)

	two = 5
	b = 3
	c = 2
	a = 4

}

function draw() {
  
  	background(50,50,50)
	strokeWeight(5)
	stroke(100,0,255,127)
	fill(100,0,255,127)

	angA = acos(-(a*a-c*c-b*b)/(2*b*c))
	angB = acos(-(b*b-a*a-c*c)/(2*c*a))
	angC = acos(-(c*c-a*a-b*b)/(2*a*b))
	fullArea = a/2 * b*sin(angC)
	scale = floor(windowWidth/a)/2
	x_a = windowWidth/2 - a*scale/2 + b*scale*cos(angC)
	y_a = windowHeight/2 - b*scale * sin(angC)/2
	x_b = windowWidth/2 + a*scale/2
	y_b = windowHeight/2 + b*scale * sin(angC)/2
	x_c = windowWidth/2 - a*scale/2
	y_c = windowHeight/2 + b*scale * sin(angC)/2
	triangle(x_c, y_c, x_b, y_b, x_a, y_a)

	var l1 = lineSlider.value()*(a+b+c)
	var l2 = l1+(a+b+c)/2

	//strokeWeight(0)
	stroke(255,100,100,127)
	fill(255,100,100,127)
	if (l1 <= a) { 
		if (l2 - a < c) { // a to c
			triangle(x_c+l1*scale, y_c, x_b-(l2-a)*scale*cos(angB), y_b-(l2-a)*scale*sin(angB), x_b, y_b)
			halfArea = (a-l1)/2 * (l2-a)*sin(angB)
		} else { // a to b
			quad(x_c+l1*scale, y_c, x_c+(a+b+c-l2)*scale*cos(angC), y_c-(a+b+c-l2)*scale*sin(angC), x_a, y_a, x_b, y_b)
			halfArea = fullArea - l1/2 * (a+b+c-l2)*sin(angC)
		}
	} else { // b to c
		triangle(x_b-(l1-a)*scale*cos(angB), y_b-(l1-a)*scale*sin(angB), x_c+(a+b+c-l2)*scale*cos(angC), y_c-(a+b+c-l2)*scale*sin(angC), x_a, y_a)
		halfArea = fullArea - ((a+b+c-l2)*cos(angC)/2*(a+b+c-l2)*sin(angC) + (l1-a)*cos(angB)/2*(l1-a)*sin(angB) + ((a+b+c-l2)*sin(angC)+(l1-a)*sin(angB))*(a-(a+b+c-l2)*cos(angC)-(l1-a)*cos(angB))/2)
	}

	strokeWeight(1)
	stroke(255, 255, 255)
	fill(255, 255, 255)
	text("a = "+a, 20, 90)
	text("b = "+b, 20, 120)
	text("c = "+c, 20, 150)
	text(fullArea/2 - halfArea, 20, 180)

}

function nextTriangle() {

	if (a - 1 > b) {
		a -= 1
		return
	}
	if (b - 1 > two/2) {
		b -= 1
		c = two - b
		return
	}
	two += 1
	b = two - 2
	c = 2
	a = two - 1

}

function reset() {
	a = 4
	b = 3
	c = 2
	two = 5
}
