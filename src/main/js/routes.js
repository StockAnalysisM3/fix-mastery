
import React, {Component} from 'react'
import {withRouter, Route, Switch} from 'react-router-dom'
import Welcome from './components/Welcome'

class Routes extends Component {

  render() {

    return (
        <Switch>
            <Route path="/" component={Welcome} />
        </Switch>
    )
  }
}

export default withRouter(Routes);