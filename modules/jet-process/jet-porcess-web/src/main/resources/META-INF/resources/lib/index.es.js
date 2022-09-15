import React from 'react';
import ReactDOM from 'react-dom';


class Main extends React.Component {
	render() {
		return (
			<div>
				<h1>Welcome!</h1>
			</div>
		);
	}
}

export default function(elementId) {
	ReactDOM.render(<Main />, document.getElementById(elementId));
}