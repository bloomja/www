
function setup() {
	
	createCanvas(windowWidth, windowHeight)
	background(50,50,50)
	textSize(30)
	
	slider = createSlider(0,2000,1000,10)
	slider.position(windowWidth/2,windowHeight/2)
	
}

function draw() {
	
	background(50,50,50)
	
	stroke(100, 50, 90)
	fill(100, 50, 90)
	
	text(slider.value(), slider.x + slider.width + 20, slider.y + 15)
	
	var sum = 0;
	for (var i = 0; i < slider.value(); i++) {
		if (i % 3 == 0 || i % 5 == 0) {
			sum += i;
		}
	}
	text(sum, slider.x + slider.width/2, slider.y + slider.height + 20);
	
}
