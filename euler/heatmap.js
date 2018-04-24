var sec = document.getElementById("progress");

var table = [];
var done = false;

for (var i = 0; !done && i < 7; i++) {
	
	table.push(document.createElement("table"));
	table[i].className = "table table-bordered heatmap";
	
	var tbody = document.createElement("tbody");
	var tr = [];
	
	for (var j = 0; !done && j < 4; j++) {
		
		tr.push(document.createElement("tr"));
		
		var td = [];
		
		for (var k = 0; !done && k < 25; k++) {
			
			var num = i*100 + j*25 + k + 1;
			if (num == 624) {
				done = true;
			}
			
			td.push(document.createElement("td"));
			switch (num) {
				case 1: td[k].className = 'completed'; td[k].title = 'Completed on 4/18/18';   td[k].innerHTML = '<a href=\'001.html\'>1</a>'; break;
				case 2: td[k].className = 'completed'; td[k].title = 'Completed on 4/19/18';   td[k].innerHTML = '<a href=\'002.html\'>2</a>'; break;
				case 3: td[k].className = 'queued';    td[k].title = 'Solution not available'; td[k].innerText = '3';													 break;
				case 4: td[k].className = 'queued';		 td[k].title = 'Solution not available'; td[k].innerText = '4';													 break;
				case 5: td[k].className = 'queued';		 td[k].title = 'Solution not available'; td[k].innerText = '5';													 break;
				case 6: td[k].className = 'queued';		 td[k].title = 'Solution not available'; td[k].innerText = '6';													 break;
				default: 																																			 td[k].innerText = num;
			}
			
			tr[j].appendChild(td[k]);
			
		}
		
		tbody.appendChild(tr[j]);
		
	}
	
	table[i].appendChild(tbody);
	
}

for (var i = 0; i < 7; i++) {
	sec.appendChild(table[i]);
}