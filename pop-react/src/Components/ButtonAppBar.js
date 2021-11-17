import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import { Link } from 'react-router-dom';

export default function ButtonAppBar() {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static" >
        <Toolbar sx={{ backgroundColor: "#00a2ff" }}>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            Sport and Food macrolist
          </Typography>
          <Link to="/foods">
            <Button color="inherit">Foodlist</Button>
          </Link>
          <Link to="/sports">
            <Button color="inherit">Sportlist</Button>
          </Link>
        </Toolbar>
      </AppBar>
    </Box>
  );
}