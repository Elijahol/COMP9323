import React, { Component } from 'react';
import NavTop from './components/NavTop'
import Footer from './components/Footer'
import './style/common.less'

class App extends Component {
  render() {
    return (
      <div className="App">

          <NavTop></NavTop>
          {this.props.children}
          {/*<Home></Home>*/}
          <Footer></Footer>
      </div>
    );
  }
}

export default App;
