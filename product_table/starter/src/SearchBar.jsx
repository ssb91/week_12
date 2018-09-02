import React, { Component } from "react";
import ReactDOM from "react-dom";

class SearchBar extends React.Component  {

render() {
return (

<form action="null">
  <input type="text" name="SearchBar" value="Search"/>
  <p><input type="checkbox" name="CheckBox" value="Stock" checked/> Only show
products in stock</p>
</form>

);
}
}

export default SearchBar;