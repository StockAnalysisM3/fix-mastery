import React, { Component } from 'react'
import ReactDOM from 'react-dom'
import Routes from './routes'
import {Router} from 'react-router-dom'
import Navigation from './components/Navigation'
import history from './history'

class App extends Component {

	render() {
		console.log(document.URL)
		return (
			<div className="text-center">
				<Navigation/>
				<h1>Welcome to the Software Guild Trading Dashboard</h1>
				<Routes/>
			</div>
		)
	}
}

ReactDOM.render(
	<Router history={history}>
		<App />
	</Router>,
	document.getElementById('react')
)