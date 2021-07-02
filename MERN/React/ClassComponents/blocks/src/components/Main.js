import React, { Component } from 'react';
import styles from './Main.module.css';

export default class Main extends Component {
  render() {
    return <div className={styles.main}>{this.props.children}</div>;
  }
}
