<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            <form class="user" action="/register/register03" method="post">
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user"  name="userId" id="exampleInputEmail" placeholder="userId">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user"  name="password" id="exampleInputEmail" placeholder="password">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user"  name="coin" id="exampleInputEmail" placeholder="coin">
                                </div>
                              
                                <button type="submit" class="btn btn-primary btn-user btn-block">
                                    Register Account
                                </button>
                                <hr>
                                <a href="/register/register03/a001/100" class="btn btn-google btn-user btn-block">
                                    <i class="fab fa-google fa-fw"></i> pathVariab;e
                                </a>
                                <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                    <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                                </a>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="login.html">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>