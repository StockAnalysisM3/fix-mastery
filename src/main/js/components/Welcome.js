import React, { Component } from 'react'
import axios from 'axios'

export default class Welcome extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             size: 0
        }
    }
    

    render() {
        return (
            <div>
                <h3>Number of Seed messages loaded: {this.state.size}</h3>
            </div>
        )
    }

    componentDidMount = async () => {
        const {data} = await axios.get("/api/messages/size")
        this.setState({size: data})
    }
}
