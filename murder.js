
var players, input1, button1, buttonArray

function preload () {
	
	players = loadStrings("murder_players.txt")
	
}

function setup () {
	
	createCanvas(windowWidth, windowHeight)
	background(50,50,50)
	textSize(20)
	fill(255,255,100)
	stroke(255,255,100)
	
	input1 = createInput()
	input1.position(10, 10)
	input1.size(windowWidth/2 - 30)
	
	button1 = createButton("Add player!")
	button1.position(input1.x + input1.width + 10, 10)
	button1.size(windowWidth/2 - 30)
	button1.mousePressed(addPlayer)
	
	var numRows = players.length / 5
	
	for (var i = 0; i < players.length; i++) {
		
		
		
	}
	
}

function addPlayer () {
	
	if (!input1.value() === "") {
		players.append(input1.value())
		save(players, 'murder_players.txt')
	}
	
}
