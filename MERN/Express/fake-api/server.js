const express = require('express');
const app = express();
const { User } = require('./User');
const { Company } = require('./Company');

app.get('/api/user/new', (req, res) => {
  res.json(new User());
})

app.get('/api/company/new', (req, res) => {
  res.json(new Company());
})

app.get('/api/user/company', (req, res) => {
  const data = {
    user: new User(),
    company: new Company(),
  }

  res.json(data);
})

app.listen(3000, () => {
  console.log('running');
})