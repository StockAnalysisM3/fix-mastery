
import React, {Component} from 'react'
import {withRouter, Route, Switch} from 'react-router-dom'
import Welcome from './components/Welcome'
import MessagesTable from './components/messages/MessagesTable';

class Routes extends Component {

  constructor(props) {
    super(props)
  
    this.state = {
       
    }
  }
  

  render() {
    // console.log(this.props.match.params.mode);
    return (
      <Switch>
        <Route path="/messages/:mode" component={MessagesTable} />
        <Route path="/" component={Welcome} />
      </Switch>
    )
  }
}

export default withRouter(Routes);