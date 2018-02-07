
var players, input1, button1

function setup () {
	
	createCanvas(windowWidth, windowHeight)
	background(50,50,50)
	textSize(20)
	fill(255,255,100)
	stroke(255,255,100)
	
	players = readTextFile("murder_players.csv")
	
	input1 = createInput()
	input1.position(10, 10)
	
	button1 = createButton("Add player!")
	button1.position(input1.x + input1.width + 10, 10)
	button1.mousePressed(addPlayer)
	
}

function addPlayer () {
	
	text(players.length, 100, 100)
	for (var i = 0; i < players.length; i++) {
		text(players[i], 10, 50 * i + 50)
	}
	
}

function readTextFile(file)
{
    var rawFile = new XMLHttpRequest();
    rawFile.open("GET", file, false);
    rawFile.onreadystatechange = function ()
    {
        if(rawFile.readyState === 4)
        {
            if(rawFile.status === 200 || rawFile.status == 0)
            {
                var allText = rawFile.responseText;
                return allText.split(",")
            }
        }
    }
    rawFile.send(null);
}