<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Cerise - Currency & Exchange Rate Information SErver for Bitcoin (BIP-017)">
    <meta name="keywords" content="Bitcoin Currency Exchange Rate Information BIP-0171 BIP171 BIP 171">

    <title>Cerise - Currency & Exchange Rate Information SErver for Bitcoin (BIP-0171)</title>

    <!-- Styles -->
    <link href="assets/css/page.min.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">

    <!-- Favicon -->
    <link rel="apple-touch-icon" sizes="57x57" href="assets/img/favicon/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="assets/img/favicon/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="assets/img/favicon/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/favicon/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="assets/img/favicon/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="assets/img/favicon/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="assets/img/favicon/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="assets/img/favicon/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="assets/img/favicon/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192" href="assets/img/favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="assets/img/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="assets/img/favicon/favicon-16x16.png">
</head>

<body>
<?php

/**
 * Display API releases.
 * @param $file page to link to.
 */
function displayAPIReleases($file)
{
    $stableReleaseFound = false;
    $allFiles = scandir("specifications", SCANDIR_SORT_DESCENDING);
    $files = array_diff($allFiles, array('.', '..'));
    foreach ($files as $key => $value) {
        // Snapshot release.
        if (strpos($value, 'SNAPSHOT') !== false) {
            ?>
            <div class="text-center mt-7">
                <a class="btn btn-outline-primary px-7"
                   href="specifications/<?php echo $value; ?>/<?php echo $file ?>"
                   target="$file-snapshot-<?php echo $value; ?>">View
                    snapshot release</a>
            </div>
            <?php
        } else {
            // Stable release.
            if (!$stableReleaseFound) {
                $stableReleaseFound = true;
                ?>
                <div class="text-center mt-7">
                    <a class="btn btn-outline-primary px-7"
                       href="specifications/<?php echo $value; ?>/<?php echo $file ?>"
                       target="$file-release-<?php echo $value; ?>">View
                        stable release</a>
                </div>
                <br>
                <p class="small text-lighter">Older releases</p>
                <?php
            } else {
                // Older releases.
                ?>
                <a href="specifications/<?php echo $value; ?>/<?php echo $file ?>"
                   target="$file-release-<?php echo $value; ?>"><?php echo $value; ?></a>
                <br>
                <?php
            }
        }
    }
}

?>

<!--================================================================================================================ -->
<!--Navigation -->
<!--================================================================================================================ -->
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">
        <!--Logo -->
        <div class="navbar-left mr-4">
            <button class="navbar-toggler" type="button">&#9776;</button>
            <a class="navbar-brand" href="#">
                <img class="logo-dark" src="assets/img/logo_small.png" alt="logo">
                <img class="logo-light" src="assets/img/logo_small.png" alt="logo">
            </a>
        </div>
        <!--Menu -->
        <section class="navbar-mobile">
            <nav class="nav nav-navbar nav-text-normal mr-auto">
                <a class="nav-link" href="#specifications">Specifications</a>
                <a class="nav-link" href="#api">API (live)</a>
                <a class="nav-link" href="#server">Server</a>
                <a class="nav-link" href="#clients">Clients</a>
                <a class="nav-link" href="https://github.com/straumat/cerise" target="github-cerise">Github</a>
                <a class="nav-link" href="mailto:stephane.traumat@gmail.com">Contact</a>
            </nav>
        </section>
    </div>
</nav>
<!--================================================================================================================ -->

<!--================================================================================================================ -->
<!--Header -->
<!--================================================================================================================ -->
<header class="header h-fullscreen"
        style="background-image: linear-gradient(135deg, #f9f7ff 0%, #fff 50%, #f6f3ff 100%);">
    <div class="container">
        <div class="row align-items-center h-100">

            <div class="col-lg-6">
                <h1 class="fw-600">
                    <span style="color:#710005">C</span>urrency & <span style="color:#710005">E</span>xchange <span
                            style="color:#710005">R</span>ate <span style="color:#710005">I</span>nformation <span
                            style="color:#710005">SE</span>rver (<a
                            href="https://github.com/bitcoin/bips/blob/master/bip-0171.mediawiki"
                            target="BIP-0171"><span
                                style="color:#710005">BIP-0171</span></a>).
                    <p class="lead mt-5 mb-5">Our aim is to provide the following artifacts : A mocked BIP 171 compliant
                        server side implementation with unit tests, a template server project allowing you to quickly
                        implement your own server and clients libraries to
                        call any BIP-0171 compliant server.</p>
                    <p class="gap-xy">
                        <a class="btn btn-round btn-primary mw-200" href="http://api.cerise.tech/docs" target="api">View
                            & test API</a>
                        <a class="btn btn-round btn-outline-secondary mw-200" href="mailto:stephane.traumat@gmail.com">Contact
                            US</a>
                    </p>
            </div>

            <div class="col-lg-5 ml-auto d-none d-lg-block">
                <img src="assets/img/logo.png" alt="img">
            </div>

        </div>
    </div>
</header>
<!--================================================================================================================ -->

<!--================================================================================================================ -->
<!-- Main Content -->
<main class="main-content">

    <!--============================================================================================================ -->
    <!--Contact us -->
    <!--============================================================================================================ -->
    <section class="section py-7" style="background-color: #8ea6e6">
        <div class="container">
            <div class="row gap-y align-items-center">
                <div class="col-md-9">
                    <h4 class="mb-0 text-white text-center text-md-left">Wants to see the API in action ?</h4>
                </div>
                <div class="col-md-3 text-center text-md-right">
                    <a class="btn btn-lg btn-round btn-light" href="http://api.cerise.tech/docs" target="api">View live
                        API</a>
                </div>
            </div>
        </div>
    </section>
    <!--============================================================================================================ -->

    <!--============================================================================================================ -->
    <!--Currency/exchange rate information API -->
    <!--============================================================================================================ -->
    <a id="specifications"></a>
    <section class="section bg-gray">
        <div class="container text-center">
            <header class="section-header">
                <h2>Currency/exchange rate information API</h2>
            </header>
            <div class="row gap-y">
                <!-- Supported currency-pair tokens -->
                <div class="col-lg-3">
                    <h6><a href="#">Supported currency-pair tokens</a></h6>
                    <hr>
                    <?php displayAPIReleases("supportedCurrencyPairTokensAPI.html"); ?>
                </div>
                <!-- Currency-pair information -->
                <div class="col-lg-3">
                    <h6><a href="#">Currency-pair information</a></h6>
                    <hr>
                    <?php displayAPIReleases("currencyPairInformationAPI.html"); ?>
                </div>
                <!-- Current exchange rate -->
                <div class="col-lg-3">
                    <h6><a href="#">Current exchange rate</a></h6>
                    <hr>
                    <?php displayAPIReleases("currentExchangeRateAPI.html"); ?>
                </div>
                <!-- Historical exchange rates -->
                <div class="col-lg-3">
                    <h6><a href="#">Historical exchange rates</a></h6>
                    <hr>
                    <?php displayAPIReleases("historicalExchangeRatesAPI.html"); ?>
                </div>
            </div>
        </div>
    </section>
    <!--============================================================================================================ -->

    <!--============================================================================================================ -->
    <!--Contact us -->
    <!--============================================================================================================ -->
    <section class="section py-7" style="background-color: #8ea6e6">
        <div class="container">
            <div class="row gap-y align-items-center">
                <div class="col-md-9">
                    <h4 class="mb-0 text-white text-center text-md-left">Any question ? Any suggestion ?</h4>
                </div>
                <div class="col-md-3 text-center text-md-right">
                    <a class="btn btn-lg btn-round btn-light" href="mailto:stephane.traumat@gmail.com">Contact us</a>
                </div>
            </div>
        </div>
    </section>
    <!--============================================================================================================ -->

    <!--============================================================================================================ -->
    <!--API (live) -->
    <!--============================================================================================================ -->
    <a id="api"></a>
    <section class="section bg-gray overflow-hidden">
        <div class="container">
            <div class="row">
                <!-- Live API description -->
                <div class="col-md-6 align-self-center text-center text-md-left">
                    <h2>API (Live documentation)</h2>
                    <br>
                    <p>Cerise provides a web interface allowing you to explore the API, view documentation and make rest
                        calls directly from your browser.</p>
                    <br>
                    <a class="btn btn-lg btn-round btn-primary shadow-3" href="http://api.cerise.tech/docs"
                       target="api">View live API</a>
                </div>
                <!-- Live API screenshots -->
                <div class="col-md-5 mx-auto text-center mt-8 mt-md-0">
                    <img src="assets/img/swagger-screenshot.png" alt="cerise api swagger screenshot" data-aos="fade-up">
                </div>
            </div>
        </div>
    </section>
    <!--============================================================================================================ -->

    <!--============================================================================================================ -->
    <!--Contact us -->
    <!--============================================================================================================ -->
    <section class="section py-7" style="background-color: #8ea6e6">
        <div class="container">
            <div class="row gap-y align-items-center">
                <div class="col-md-9">
                    <h4 class="mb-0 text-white text-center text-md-left">Any question ? Any suggestion ?</h4>
                </div>
                <div class="col-md-3 text-center text-md-right">
                    <a class="btn btn-lg btn-round btn-light" href="mailto:stephane.traumat@gmail.com">Contact us</a>
                </div>
            </div>
        </div>
    </section>
    <!--============================================================================================================ -->

    <!--============================================================================================================ -->
    <!--Server -->
    <!--============================================================================================================ -->
    <a id="server"></a>
    <section class="section">
        <div class="container">
            <div class="row gap-y text-center">
                <!-- Cerise mocked server -->
                <div class="col-md-6">
                    <h2>Cerise mocked server</h2>
                    <p>Cerise mocked server is a mocked implementation of the BIP-0171 specifications. It includes
                        the four methods with mocked responses and unit test. It also provides a web user interface
                        to explore and run REST calls.</p>
                    <a class="btn btn-outline-primary px-7" href="https://github.com/straumat/cerise"
                       target="cerise">Get cerise server</a><br>
                    <br>
                    <p><a href="https://hub.docker.com/r/straumat/cerise/" target="docker"><i>We also provide a docker
                                image here.</i></a></p>
                </div>
                <!-- Cerise template server -->
                <div class="col-md-6">
                    <h2>Cerise template server</h2>
                    <p>Cerise template server is a template project allowing you to quickly develop your own BIP 0171
                        compliant server. This project is based on Cerise mocked server and thanks to it, you only have
                        to implement four java services, we take care of the rest (request parameters and results,
                        documentation, security...).</p>
                    <a class="btn btn-outline-primary px-7" href="#"
                       target="cerise">Not released yet</a>
                </div>
            </div>
        </div>
    </section>
    <!--============================================================================================================ -->

    <!--============================================================================================================ -->
    <!--Get the source -->
    <!--============================================================================================================ -->
    <section class="section py-7" style="background-color: #8ea6e6">
        <div class="container">
            <div class="row gap-y align-items-center">
                <div class="col-md-9">
                    <h4 class="mb-0 text-white text-center text-md-left">Get the source !</h4>
                </div>
                <div class="col-md-3 text-center text-md-right">
                    <a class="btn btn-lg btn-round btn-light" href="https://github.com/straumat/cerise">view github</a>
                </div>
            </div>
        </div>
    </section>
    <!--============================================================================================================ -->


</main>
<!--================================================================================================================ -->

<!--================================================================================================================ -->
<!-- Footer -->
<!--================================================================================================================ -->
<footer class="footer bg-gray py-9">
    <div class="container">
        <div class="row gap-y">

            <div class="col-md-6 col-xl-4">
                <p><a href="#"><img src="assets/img/logo/mailchimp.png" alt="logo"></a></p>
                <p>We can combine beautiful, modern designs with clean, functional and high-performance code to produce
                    stunning websites.</p>
            </div>

            <div class="col-6 col-md-3 col-xl-2">
                <h6 class="mb-4 mt-1"><strong>Company</strong></h6>
                <div class="nav flex-column">
                    <a class="nav-link" href="#">About</a>
                    <a class="nav-link" href="#">Careers</a>
                    <a class="nav-link" href="#">Contact</a>
                </div>
            </div>

            <div class="col-6 col-md-3 col-xl-2">
                <h6 class="mb-4 mt-1"><strong>Product</strong></h6>
                <div class="nav flex-column">
                    <a class="nav-link" href="#">Features</a>
                    <a class="nav-link" href="#">Pricing</a>
                    <a class="nav-link" href="#">Security</a>
                </div>
            </div>

            <div class="col-6 col-md-6 col-xl-2">
                <h6 class="mb-4 mt-1"><strong>Support</strong></h6>
                <div class="nav flex-column">
                    <a class="nav-link" href="#">Help Center</a>
                    <a class="nav-link" href="#">API</a>
                    <a class="nav-link" href="#">FAQ</a>
                </div>
            </div>

            <div class="col-6 col-md-6 col-xl-2 text-center">
                <p><a class="btn btn-block btn-round btn-secondary" href="#">Try it free</a></p>
                <br>
                <div class="social social-bordered">
                    <a class="social-facebook" href="#"><i class="fa fa-facebook"></i></a>
                    <a class="social-twitter" href="#"><i class="fa fa-twitter"></i></a>
                    <a class="social-youtube" href="#"><i class="fa fa-youtube"></i></a>
                    <a class="social-instagram" href="#"><i class="fa fa-instagram"></i></a>
                </div>
            </div>

        </div>
    </div>
</footer>
<!--================================================================================================================ -->

<!--================================================================================================================ -->
<!-- Scripts -->
<script src="assets/js/page.min.js"></script>
<script src="assets/js/script.js"></script>
<!--================================================================================================================ -->

</body>
</html>
