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

        <div class="navbar-left mr-4">
            <button class="navbar-toggler" type="button">&#9776;</button>
            <a class="navbar-brand" href="#">
                <img class="logo-dark" src="assets/img/logo_small.png" alt="logo">
                <img class="logo-light" src="assets/img/logo_small.png" alt="logo">
            </a>
        </div>

        <section class="navbar-mobile">
            <nav class="nav nav-navbar nav-text-normal mr-auto">
                <a class="nav-link" href="#specifications">Specifications</a>
                <a class="nav-link" href="#">API</a>
                <a class="nav-link" href="#">Server</a>
                <a class="nav-link" href="#">Clients</a>
                <a class="nav-link" href="#">Github</a>
                <a class="nav-link" href="#">Contact</a>
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
                        <a class="btn btn-round btn-primary mw-200" href="#">View & test API</a>
                        <a class="btn btn-round btn-outline-secondary mw-200" href="#">Contact US</a>
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

    <!--
    |‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒
    | Send better email
    |‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒
    !-->
    <section class="section">
        <div class="container">
            <header class="section-header">
                <small>Feature</small>
                <h2>Send better email</h2>
                <hr>
                <p class="lead">Whether you need to sell your products, share some big news, or tell a story, our
                    campaign builder makes it easy to create email campaigns that best suit your message.</p>
            </header>


            <div class="row gap-y">

                <div class="col-md-8 mx-auto mb-7">
                    <img src="assets/img/preview/feature-tablet.png" alt="..." data-aos="fade-up"
                         data-aos-duration="2000">
                </div>


                <div class="w-100"></div>


                <div class="col-md-6 col-xl-4">
                    <div class="media">
                        <div class="lead-6 line-height-1 text-lighter w-70px"><i class="icon-mobile"></i></div>
                        <div class="media-body">
                            <h5>Responsive</h5>
                            <p>Your website works on any device: desktop, tablet or mobile.</p>
                        </div>
                    </div>
                </div>


                <div class="col-md-6 col-xl-4">
                    <div class="media">
                        <div class="lead-6 line-height-1 text-lighter w-70px"><i class="icon-gears"></i></div>
                        <div class="media-body">
                            <h5>Customizable</h5>
                            <p>You can easily read, edit, and write your own code, or change everything.</p>
                        </div>
                    </div>
                </div>


                <div class="col-md-6 col-xl-4">
                    <div class="media">
                        <div class="lead-6 line-height-1 text-lighter w-70px"><i class="icon-tools"></i></div>
                        <div class="media-body">
                            <h5>UI Kit</h5>
                            <p>There is a bunch of useful and necessary elements for developing your website.</p>
                        </div>
                    </div>
                </div>


                <div class="col-md-6 col-xl-4">
                    <div class="media">
                        <div class="lead-6 line-height-1 text-lighter w-70px"><i class="icon-layers"></i></div>
                        <div class="media-body">
                            <h5>Lego Base</h5>
                            <p>You can find our code well organized, commented and readable.</p>
                        </div>
                    </div>
                </div>


                <div class="col-md-6 col-xl-4">
                    <div class="media">
                        <div class="lead-6 line-height-1 text-lighter w-70px"><i class="icon-recycle"></i></div>
                        <div class="media-body">
                            <h5>Clean Code</h5>
                            <p>As you can see in the source code, we provided a clean code.</p>
                        </div>
                    </div>
                </div>


                <div class="col-md-6 col-xl-4">
                    <div class="media">
                        <div class="lead-6 line-height-1 text-lighter w-70px"><i class="icon-chat"></i></div>
                        <div class="media-body">
                            <h5>Support</h5>
                            <p>When you purchase this template, you'll freely receive future updates.</p>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </section>


    <!--
    |‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒
    | Automate your marketing
    |‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒
    !-->
    <section class="section bg-gray overflow-hidden">
        <div class="container">
            <div class="row">

                <div class="col-md-6 align-self-center text-center text-md-left">
                    <h2>Automate your marketing</h2><br>
                    <p>Keep a personal touch while removing manual tasks from your to-do list. Pre-built marketing
                        automation creates room to focus on strategy. Welcome, re-engage, and follow up with the people
                        who matter to you. If you're new to marketing automation, get up to speed with one of our nifty
                        guides: What is Marketing Automation?</p>
                    <br>
                    <a class="btn btn-lg btn-round btn-primary shadow-3" href="#">Get Start Now</a>
                </div>

                <div class="col-md-5 mx-auto text-center mt-8 mt-md-0">
                    <img src="assets/img/preview/phone-2.png" alt="..." data-aos="fade-up">
                </div>

            </div>
        </div>
    </section>


    <!--
    |‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒
    | Test drive
    |‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒
    !-->
    <section class="section py-7" style="background-color: #8ea6e6">
        <div class="container">
            <div class="row gap-y align-items-center">
                <div class="col-md-9">
                    <h4 class="mb-0 text-white text-center text-md-left">Want a bite? You're in the right place!</h4>
                </div>

                <div class="col-md-3 text-center text-md-right">
                    <a class="btn btn-lg btn-round btn-light" href="#">Take a test drive</a>
                </div>
            </div>
        </div>
    </section>


    <!--
    |‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒
    | Testimonials
    |‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒
    !-->
    <section class="section">
        <div class="container">
            <header class="section-header">
                <small>Testimonials</small>
                <h2>What customers say about us</h2>
                <hr>
                <p class="lead">We waited until we could do it right. Then we did! Instead of creating a carbon
                    copy.</p>
            </header>

            <div class="row gap-y text-center">

                <div class="col-md-6">
                    <blockquote class="blockquote">
                        <div><img class="avatar avatar-xl" src="assets/img/avatar/1.jpg" alt="..."></div>
                        <br>
                        <p>When you innovate, you make mistakes. It is best to admit them quickly, and get on with
                            improving your other innovations.</p>
                        <footer>Steve Jobs</footer>
                    </blockquote>
                </div>

                <div class="col-md-6">
                    <blockquote class="blockquote">
                        <div><img class="avatar avatar-xl" src="assets/img/avatar/2.jpg" alt="..."></div>
                        <br>
                        <p>Technology is just a tool. In terms of getting the kids working together and motivating them,
                            the teacher is important.</p>
                        <footer>Bill Gates</footer>
                    </blockquote>
                </div>

            </div>

        </div>
    </section>


    <!--
    |‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒
    | CTA
    |‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒
    !-->
    <section class="section py-7">
        <div class="container">
            <div class="row gap-y align-items-center">
                <div class="col-md-6 text-center text-md-left">
                    <h3>Try it for free</h3>
                    <p>Already using MailChimp? <a href="#">Sign in</a></p>
                </div>

                <div class="col-md-auto ml-auto text-center text-md-right">
                    <form class="form-inline justify-content-center">
                        <div class="form-group">
                            <input type="text" class="form-control w-250 mb-2 mr-sm-2" placeholder="Email address">
                        </div>
                        <button type="submit" class="btn btn-lg btn-primary mb-2">Get Started</button>
                    </form>
                </div>
            </div>
        </div>
    </section>


    <!--
    |‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒
    | Partners
    |‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒
    !-->
    <section class="section py-6 d-none">
        <div class="container">

            <div class="partner partner-sm">
                <img src="assets/img/partner/1.png" alt="partner 1">
                <img src="assets/img/partner/2.png" alt="partner 2">
                <img src="assets/img/partner/3.png" alt="partner 3">
                <img src="assets/img/partner/4.png" alt="partner 4">
                <img src="assets/img/partner/5.png" alt="partner 5">
                <img src="assets/img/partner/6.png" alt="partner 6">
            </div>

        </div>
    </section>

</main>


<!-- Footer -->
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
</footer><!-- /.footer -->


<!-- Offcanvas - Search -->
<div id="offcanvas-search" class="offcanvas text-white" data-animation="fade"
     style="background-color: rgba(255,73,84,0.9)">
    <button type="button" class="close" data-dismiss="offcanvas" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
    <div class="row align-items-center text-center h-90">
        <div class="col-10 col-md-6 mx-auto">
            <form class="input-transparent">
                <input class="form-control form-control-lg border-0 lead-5" type="text" name="search"
                       placeholder="Enter your keywords here">
            </form>
        </div>
    </div>
</div>

<!-- Scripts -->
<script src="assets/js/page.min.js"></script>
<script src="assets/js/script.js"></script>

</body>
</html>
