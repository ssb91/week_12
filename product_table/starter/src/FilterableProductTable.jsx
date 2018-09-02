import React, { Component } from "react";
import ReactDOM from "react-dom";

import SearchBar from './SearchBar';
import ProductTable from './ProductTable';
import ProductCategoryRow from './ProductCategoryRow';
import ProductRow from './ProductRow';

class FilterableProductTable extends React.Component {

render() {
return (
<div>
<SearchBar />
<ProductTable />
<ProductCategoryRow />
<ProductRow />
</div>
);
}
}

export default FilterableProductTable;