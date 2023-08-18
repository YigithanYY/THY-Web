import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import HeaderCompononet from './components/HeaderComponents';
import ListStudentsComplements from './components/ListStudentsComplements';
import AddStudentComplement from './components/AddStudentComponent';
import UpdateStudentComponents from './components/UpdateStudentComponents';
import { PrimeReactProvider } from 'primereact/api';
        

import 'primereact/resources/themes/arya-blue/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';

function App() {
  return (

    
    
      <PrimeReactProvider>
      <div className='App'>
      <Router>
      <HeaderCompononet/>
      <div className='container'>
      <Routes>
        <Route exact path="/" element={<ListStudentsComplements/>}/>
        <Route path="/students" element={<ListStudentsComplements/>}/>
        <Route path="/students/add" element={<AddStudentComplement/>}/>
        <Route path="/students/update/:id" element={<UpdateStudentComponents/>}/>

      </Routes>
      </div>

      </Router>
      </div>
      </PrimeReactProvider>
    
  );
}

export default App;
