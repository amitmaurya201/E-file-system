import React from "react";

const Navbar = () => {
return (
<div>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
<div class="container-fluid">

  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-link" href="/web/guest/file/-/jetprocessreact_INSTANCE_TvrAY0BwgfGP/create-file"><b>Create File</b></a>
      <a class="nav-link" href="/web/guest/file/-/jetprocessreact_INSTANCE_TvrAY0BwgfGP/view-file"><b>View File</b></a>
      <a class="nav-link" href="/web/guest/file/-/jetprocessreact_INSTANCE_TvrAY0BwgfGP/create-receipt"><b>Create Receipt</b></a>
      <a class="nav-link" href="/web/guest/file/-/jetprocessreact_INSTANCE_TvrAY0BwgfGP/view-receipt"><b>View Receipt</b></a>
    </div>    
  </div>
</div>
</nav>
</div>

);


};
export default Navbar; 