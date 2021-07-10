import './App.css';

import { Switch, Route } from 'react-router-dom';

import Home from './components/Home';
import Number from './components/Number';
import Text from './components/Text';
import TextOnly from './components/TextOnly';

function App() {
  return (
    <div className="App">
      <h1>Router</h1>
      <Switch>
        <Route path="/home" component={Home} />
        <Route exact path="/:num(\d+)" component={Number} />
        <Route exact path="/:str" component={TextOnly} />
        <Route path="/:str/:color/:background" component={Text} />
      </Switch>
    </div>
  );
}

export default App;
