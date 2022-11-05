import React from "react";

const Navbar = () => {
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
        <div className="container-fluid">
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div className="navbar-nav">
              <a className="nav-link" href="/web/jet-process/8fbbe737-5dca-5154-f69b-7bab24f2e8b6/-/jetprocessreact_INSTANCE_mria/home"><b>Home</b></a>
              <a className="nav-link" href="/web/jet-process/8fbbe737-5dca-5154-f69b-7bab24f2e8b6/-/jetprocessreact_INSTANCE_mria/create-file"><b>Create File</b></a>
              <a className="nav-link" href="/web/jet-process/8fbbe737-5dca-5154-f69b-7bab24f2e8b6/-/jetprocessreact_INSTANCE_mria/view-file"><b>View File</b></a>
              <a className="nav-link" href="/web/jet-process/8fbbe737-5dca-5154-f69b-7bab24f2e8b6/-/jetprocessreact_INSTANCE_mria/create-receipt/:receiptId"><b>Create Receipt</b></a>
              <a className="nav-link" href="/web/jet-process/8fbbe737-5dca-5154-f69b-7bab24f2e8b6/-/jetprocessreact_INSTANCE_mria/view-receipt"><b>View Receipt</b></a>
            </div>
          </div>
        </div>
      </nav>
    </div>
  );
};
export default Navbar; 