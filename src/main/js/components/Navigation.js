import React, { Component } from 'react'
import {Navbar, Nav} from 'react-bootstrap'

export default class Navigation extends Component {
    render() {
        return (
        <Navbar bg="primary" variant="dark">
            <Navbar.Brand href="#home">Vending Machine</Navbar.Brand>
            <Nav className="mr-auto d-flex justify-content-around">
              <Nav.Link href="/">Home</Nav.Link>
            </Nav>
          </Navbar>
        )
    }
}
