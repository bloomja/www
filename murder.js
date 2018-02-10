
var players, input1, button1

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
	
	var numCols = 5
	var numRows = ceil(players.length / numCols)
	var buttonArray = []
	var btnWidth = windowWidth/numCols - 10 * (numCols+1)
	var btnHeight = windowHeight/numRows - input1.height - 10 * (numRows+3)
	
	for (var i = 0; i < players.length; i++) {
		
		var newBtn = createButton(players[i])
		
		if (i == 0) {
			newBtn.position(10, input1.height + 10)
		} else if (i % numCols != 0) {
			newBtn.position(buttonArray[i-1].x + btnWidth + 10, buttonArray[i-1].y)
		} else {
			newBtn.position(buttonArray[i-5].x, buttonArray[i-5].y + btnHeight + 10)
		}
		
		newBtn.size(btnWidth, btnHeight)
		//newBtn.mousePressed(addPlayer)
		buttonArray.push(newBtn)
		
	}
	
}

function addPlayer () {
	
	if (input1.value()) {
		players.append(input1.value())
		save(players, 'murder_players.txt')
	}
	
}
