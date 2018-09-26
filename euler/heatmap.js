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
			if (num == 636) {
				done = true;
			}
			
			td.push(document.createElement("td"));
			switch (num) {
				case   1: td[k].className = 'completed'; 	td[k].title = 'Completed on 4/18/18';   td[k].innerHTML = '<a href=\'001.html\'>1</a>'; break;
				case   2: td[k].className = 'completed';	td[k].title = 'Completed on 4/19/18';   td[k].innerHTML = '<a href=\'002.html\'>2</a>'; break;
				case   3: td[k].className = 'queued';    	td[k].title = 'Solution not available'; td[k].innerText = '3';							break;
				case   4: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '4';							break;
				case   5: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '5';							break;
				case   6: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '6';							break;
				case   7: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '7';							break;
				case   8: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '8';							break;
				case   9: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '9';							break;
				case  10: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '10';							break;
				case  11: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '11';							break;
				case  12: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '12';							break;
				case  13: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '13';							break;
				case  14: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '14';							break;
				case  15: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '15';							break;
				case  16: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '16';							break;
				case  17: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '17';							break;
				case  18: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '18';							break;
				case  19: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '19';							break;
				case  20: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '20';							break;
				case  21: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '21';							break;
				case  22: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '22';							break;
				case  23: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '23';							break;
				case  24: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '24';							break;
				case  25: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '25';							break;
				case  26: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '26';							break;
				case  27: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '27';							break;
				case  28: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '28';							break;
				case  29: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '29';							break;
				case  30: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '30';							break;
				case  31: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '31';							break;
				case  32: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '32';							break;
				case  33: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '33';							break;
				case  34: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '34';							break;
				case  35: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '35';							break;
				case  36: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '36';							break;
				case  37: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '37';							break;
				case  38: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '38';							break;
				case  39: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '39';							break;
				case  40: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '40';							break;
				case  41: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '41';							break;
				case  42: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '42';							break;
				case  43: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '43';							break;
				case  44: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '44';							break;
				case  45: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '45';							break;
				case  46: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '46';							break;
				case  47: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '47';							break;
				case  48: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '48';							break;
				case  49: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '49';							break;
				case  50: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '50';							break;
				case  52: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '52';							break;
				case  53: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '53';							break;
				case  54: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '54';							break;
				case  55: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '55';							break;
				case  56: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '56';							break;
				case  57: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '57';							break;
				case  58: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '58';							break;
				case  59: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '59';							break;
				case  63: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '63';							break;
				case  67: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '67';							break;
				case  69: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '69';							break;
				case  71: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '71';							break;
				case  76: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '76';							break;
				case  79: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '79';							break;
				case  81: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '81';							break;
				case  92: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '92';							break;
				case  97: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '97';							break;
				case  99: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '99';							break;
				case 206: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '206';						break;
				case 357: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '357';						break;
				case 493: td[k].className = 'queued';		td[k].title = 'Solution not available'; td[k].innerText = '493';						break;
				default: 																			td[k].innerText = num;
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