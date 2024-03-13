/**
 * 
 */

document.addEventListener("DOMContentLoaded", function() {
	document.getElementById('playerOnBoardForm').addEventListener('submit', function(event) {
		if (!checkEmptyValues()) {
			console.log('Check if');
		}
		event.preventDefault();
		playerOnBoard();
	});
});

function checkEmptyValues() {
	if (document.getElementById('playerName1').value === "") {
		alert("Enter Player1 name");
		return false;
	}
	if (document.getElementById('playerName2').value === "") {
		alert("Enter Player2 name");
		return false;
	}
	return true;
}

function playerOnBoard() {
	// Get the form data
	const formData = new FormData(document.getElementById('playerOnBoardForm'));

	for (const pair of formData.entries()) {
		console.log(pair[0] + ', ' + pair[1]);
	}
	
	const urlSearchParams = new URLSearchParams(formData);
    const encodedFormData = new URLSearchParams(urlSearchParams).toString();

	fetch('PlayerOnBoard', {
		method: 'POST',
		headers : {
			'Content-Type': 'application/x-www-form-urlencoded',
		},
		body: encodedFormData
	})
		.then(response => {
			if (!response.ok) {
				throw new Error(`HTTP error! Status: ${response.status}`);
			}
			console.log('After Getting response1');
			return response.text();
		})
		.then(redirectUrl => {
			console.log('After Getting response2 ' + redirectUrl);
			window.location.href = redirectUrl;
		})
		.catch(error => {
			console.log('After Getting error');
			console.error('Error calling playerOnBoard API:', error);
		});
}