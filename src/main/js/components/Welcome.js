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
                <h3>Current Example States loaded: {this.state.size}</h3>
            </div>
        )
    }

    componentDidMount = async () => {
        const {data} = await axios.get("/api/categories/orderstatus/size")
        this.setState({size: data})
    }
}
