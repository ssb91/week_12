import React, { Component } from 'react';

import FilterableProductTable from './FilterableProductTable';


class App extends Component {
  render() {
    return (
      <React.Fragment>
        <h1>Filterable Product Table</h1>
        <hr/>
	  <FilterableProductTable />
		
      </React.Fragment>
	  
    );
  }
}

export default App;
