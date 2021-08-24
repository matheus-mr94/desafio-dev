import { BrowserRouter,Route,Switch } from 'react-router-dom';
import Home from '../Paginas/Home';
import Lojas from '../Paginas/Lojas';
import { useState, useEffect } from 'react';
import CadastroUsuario from '../Paginas/CadastroUsuario';
import CadastroLoja from '../Paginas/Lojas/CadastroLoja';

function Rotas(){

    const [token, setToken] = useState("");
    const onLogin = (token) => {
      setToken(token);
      

    };
  
    const logout = () => {
      setToken("");
    };
  
    useEffect(() => {
      const tokenAntigo = localStorage.getItem('token')
      if (tokenAntigo) {
        setToken(tokenAntigo)
      }
    }, [])
    

    return(
        <BrowserRouter>
      
            <Switch>
                <Route exact path="/" token={token} onLogin={onLogin}>
                    <Home/>
                </Route>
                <Route path="/cadastro">
                    <CadastroUsuario/>
                </Route>
                <Route path="/lojas">
                    <Lojas/>
                </Route>
                <Route path="/loja/cadastro">
                    <CadastroLoja/>
                </Route>
            </Switch>
        </BrowserRouter>
    )
}

export default Rotas;