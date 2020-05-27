import React, { Component } from 'react';
import MessageInstance from './MessageInstance'
import axios from 'axios'

export default class MessagesTable extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
            messages: []
        }
    }
    

    componentDidMount = async () => {
        const {data} = await axios.get("/api/messages/all")
        this.setState({messages: data})
    }

    renderMessagePerData = () => {
        const {messages} = this.state;
        return (
            <tbody>
                {messages.map(
                    message => <MessageInstance key={message.id} message={message} />
                )}
            </tbody>
        )
    }

    render() {
        return (
            <table>
                <thead>
                    <tr>  
                        <th>System</th>
                        <th>Time Stamp</th>
                        <th>Message</th>
                    </tr>
                </thead>
                {this.renderMessagePerData()}
            </table>
        )
    }
}
