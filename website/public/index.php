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
 * @param $file String page to link to.
 */
function displayAPIReleases($file)
{
    $stableReleaseFound = false;
    $snapshotFound = false;
    $directories = scandir("specifications", SCANDIR_SORT_DESCENDING);
    $releases = array_diff($directories, array('.', '..', '.empty'));

    foreach ($releases as $key => $value) {
        // Snapshot release.
        if (strpos($value, 'SNAPSHOT') !== false && !$snapshotFound) {
            $snapshotFound = true;
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
            if (!$stableReleaseFound && strpos($value, 'SNAPSHOT') === false) {
                $stableReleaseFound = true;
                ?>
                <div class="text-center mt-7">
                    <a class="btn btn-outline-primary px-7"
                       href="specifications/<?php echo $value; ?>/<?php echo $file ?>"
                       target="$file-release-<?php echo $value; ?>">View
                        stable release</a>
                </div>
                <br>
                <?php
            } else if (strpos($value, 'SNAPSHOT') === false) {
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
            <a class="navbar-brand" href="#home">
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
            </nav>
        </section>
    </div>
</nav>
<!--================================================================================================================ -->

<!--================================================================================================================ -->
<!--Header -->
<!--================================================================================================================ -->
<a id="home"></a>
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
                                style="color:#710005">BIP-0171</span></a>).</h1>
                <p class="lead mt-5 mb-5">
                    We provide <a href="#specifications">BIP-0171 specifications</a>, a <a
                            href="https://github.com/straumat/cerise-server-mock"
                            target="cerise-server-mock-java">mocked
                        BIP-0171 compliant server as a Java application</a>, a <a
                            href="https://hub.docker.com/r/straumat/cerise-server-mock/"
                            target="cerise-server-mock-docker">mocked BIP-0171 compliant server as a Docker
                        image</a>, a <a href="https://github.com/straumat/cerise" target="cerise">BIP-0171 library
                        to
                        transform your application in a BIP-0171 server</a>,a <a
                            href="https://github.com/straumat/cerise-server-template"
                            target="cerise-server-template">server template project to quickly write your
                        implementation and automatically produce your BIP-0171 server</a>, and a <a href="#clients">collection
                        of client
                        libraries to call any BIP-0171 compliant server with your favorite language</a>.</p>
                <p class="gap-xy">
                    <a class="btn btn-round btn-primary mw-200" href="http://api.cerise.tech/docs" target="api">View
                        & test API</a>
                    <a class="btn btn-round btn-outline-secondary mw-200" href="mailto:contact@cerise.tech">Contact
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
                    <h4 class="mb-0 text-white text-center text-md-left">Any question ? Any suggestion ?</h4>
                </div>
                <div class="col-md-3 text-center text-md-right">
                    <a class="btn btn-lg btn-round btn-light" href="mailto:contact@cerise.tech">Contact us</a>
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
                    <a class="btn btn-lg btn-round btn-light" href="mailto:contact@cerise.tech">Contact us</a>
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
                    <a class="btn btn-lg btn-round btn-light" href="mailto:contact@cerise.tech">Contact us</a>
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
                        to explore and run REST calls easily.</p>
                    <a class="btn btn-outline-primary px-7" href="https://github.com/straumat/cerise-server-mock"
                       target="cerise-server-mock">Get mocked cerise server</a><br>
                    <br>
                    <p><a href="https://hub.docker.com/r/straumat/cerise-server-mock/"
                          target="cerise-server-mock-docker"><i>We also provide a docker image here.</i></a></p>
                </div>
                <!-- Cerise template server -->
                <div class="col-md-6">
                    <h2>Cerise template server</h2>
                    <p>Cerise template server is a template project allowing you to quickly develop your own BIP 0171
                        compliant server. You only have to implement four java services, we take care of the rest
                        (request parameters and results, documentation...).</p>
                    <a class="btn btn-outline-primary px-7" href="https://github.com/straumat/cerise-server-template"
                       target="cerise-server-template">Get cerise server template</a>
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
                    <a class="btn btn-lg btn-round btn-light" href="mailto:contact@cerise.tech">Contact us</a>
                </div>
            </div>
        </div>
    </section>
    <!--============================================================================================================ -->

    <!--============================================================================================================ -->
    <!--Clients -->
    <!--============================================================================================================ -->
    <a id="clients"></a>
    <section class="section py-7">
        <div class="container">
            <div class="row gap-y align-items-center">
                <div class="col-md-6 text-center text-md-left">
                    <h3>Get client libraries for your favorite language</h3>
                </div>
                <div class="col-md-auto ml-auto text-center text-md-right">
                    <select title="releases" id="releases">
                        <?php
                        $latestReleaseFound = false;
                        $snapshotFound = false;
                        $latestReleaseDirectory = "";
                        $directories = scandir("clients", SCANDIR_SORT_DESCENDING);
                        $releases = array_diff($directories, array('.', '..', '.empty'));
                        foreach ($releases as $key => $value) {
                            // Selecting the value for the option.
                            if (!$latestReleaseFound) {
                                $latestReleaseDirectory = $value;
                                $latestReleaseFound = true;
                            }

                            // if we found
                            if (strpos($value, 'SNAPSHOT') !== false && !$snapshotFound) {
                                ?>
                                <option value="<?php echo $value ?>"><?php echo $value; ?></option>
                                <?php
                                $snapshotFound = true;
                            }

                            if (strpos($value, 'SNAPSHOT') === false) {
                                ?>
                                <option value="<?php echo $value ?>"><?php echo $value; ?></option>
                                <?php
                            }
                        }
                        ?>
                    </select>
                    <script>
                        // Change of releases.
                        var selectChange = function () {
                            // get the selected value.
                            var e = document.getElementById("releases");
                            var release = e.options[e.selectedIndex].text;

                            // Iterate throw releases.
                            var inputs = document.getElementsByClassName("client");
                            for (var i = 0; i < inputs.length; i++) {
                                var originalHref = inputs[i].getAttribute("href").valueOf();
                                var index = originalHref.indexOf("/cerise-");
                                // Generate the new value.
                                var newValue = originalHref.substring(0, 9) + release + originalHref.substring(index, originalHref.length);
                                inputs[i].setAttribute("href", newValue);
                            }

                        };
                        document.getElementById("releases").onclick = selectChange;
                    </script>

                </div>
            </div>
            <div class="row gap-y text-center">
                <?php
                $directories = scandir("clients/" . $latestReleaseDirectory);
                $clients = array_diff($directories, array('.', '..', '.empty'));
                foreach ($clients as $key => $value) {
                    $language = $value;
                    $language = str_replace("cerise-client-", "", $value);
                    $language = str_replace(".zip", "", $language);
                    ?>
                    <div class="col-md-4">
                        <h2><?php echo ucfirst($language); ?></h2>
                        <a class="btn btn-outline-primary px-7 client"
                           href=" <?php echo "clients/" . $latestReleaseDirectory . "/" . $value; ?>"
                           target="cerise">Get client library</a><br>
                        <br>
                    </div>
                    <?php
                }
                ?>
            </div>

    </section>
    <!--============================================================================================================ -->

</main>
<!--================================================================================================================ -->

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
                <a class="btn btn-lg btn-round btn-light" href="mailto:contact@cerise.tech">Contact us</a>
            </div>
        </div>
    </div>
</section>
<!--============================================================================================================ -->

<!--================================================================================================================ -->
<!-- Footer -->
<!--================================================================================================================ -->
<footer class="footer bg-gray py-2">
    <p align="center"><a href="#home"><img src="assets/img/logo.png"
                                           alt="Currency & Exchange Rate Information SErver (BIP-0171)"></a>
    </p>
</footer>
<!--================================================================================================================ -->

<!--================================================================================================================ -->
<!-- Scripts -->
<script src="assets/js/page.min.js"></script>
<script src="assets/js/script.js"></script>
<!--================================================================================================================ -->

</body>
</html>
