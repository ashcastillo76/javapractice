import React from "react";
import About from "./components/About";
import Contact from "./components/Contact";
import Navbar from "./components/Navbar";
import Projects from "./components/Projects";
import Skills from "./components/Skills";
import Resume from "./components/Resume";
import "bootstrap/dist/css/bootstrap.min.css";

export default function App() {
  return (
    <main>
      <Navbar/>
      <About/>
      <Projects/>
      <Skills/>
      <Resume/>
      <Contact/>
    </main>
  );
}
