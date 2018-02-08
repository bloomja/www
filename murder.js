
var players, input1, button1

function preload () {
	
	players = loadStrings("murder_players.csv")
	console.log(players)
	
}

function setup () {
	
	createCanvas(windowWidth, windowHeight)
	background(50,50,50)
	textSize(20)
	fill(255,255,100)
	stroke(255,255,100)
	
	text(players.length, 100, 100)
	
	input1 = createInput()
	input1.position(10, 10)
	
	button1 = createButton("Add player!")
	button1.position(input1.x + input1.width + 10, 10)
	button1.mousePressed(addPlayer)
	
}
