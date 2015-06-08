$(document)
		.ready(
				function() {
					var SERVICE_URL_PREFIX = "/sf_movies/services/rest";

					var SEARCH_SERVICE_PATH_URL = "/search";
					var MOVIE_VIEW_DIV_TEMPELATE = "<div id=\"movie-{!id_placeholder}\"><div class=\"panel panel-default\" > "
							+ "<div class=\"panel-heading\">Title: {!heading_placheholder}</div>"
							+ "</div>"
							+ "<div id=\"movieDetails\">"
							+ "<ul>"
							+ "<li>year: {!movie_release_year_placeholder}</li>"
							+ "<li> director: {!movie_director_placeholder}</li>"
							+ "<li> address: {!movie_address_location}</li>"
							+ "</ul>" + "</div>" + "<hr>";

					jQuery.fn.outerHTML = function() {
						return jQuery('<div />').append(this.eq(0).clone())
								.html();
					};

					var MovieService = {
						movieServiceURL : SERVICE_URL_PREFIX + "/movie/",
						getMovies : function(title, pageNo, count,
								successCallback, errorCallback) {
							function getQueryStringForAllMovies(title, pageNo,
									count) {
								var queryString = "?"
								if (pageNo) {
									queryString += "page=" + pageNo + "&";
								}
								if (count) {
									queryString += "count=" + count + "&";
								}
								if (title) {
									queryString += "title=" + title + "&";
								}
								return queryString.replace(/&$/, "");
							}
							$.ajax({
								url : this.movieServiceURL
										+ "@all"
										+ getQueryStringForAllMovies(title,
												pageNo, count),
								success : function(result) {
									if (successCallback) {
										successCallback(result);
									}
								},
								error : function(error) {
									if (errorCallback) {
										errorCallback(error);
									}
								}

							});
						},
						getMovie : function(movieId, successCallbcack,
								errorCallback) {
							$.ajax({
								url : this.movieServiceURL + movieId,
								success : function(result) {
									if (successCallbcack) {
										successCallback(result);
									}
								},
								error : function(error) {
									if (errorCallback) {
										errorCallback(error);
									}
								}
							});
						},

					}
					var that;
					var SfMoiveView = {
						init : function() {
							that = this;
							return this;
						},
						markerMap : {},
						currPageNo : 0,
						totalPages : 0,
						title: undefined,
						addMapMarker : function(id, coordinates, movieTitle) {
							var latlng = new google.maps.LatLng(
									coordinates.latitude, coordinates.longitude);
							var marker = new google.maps.Marker({
								position : latlng,
								map : map,
								title : movieTitle,
								animation : google.maps.Animation.DROP,
							});
							that.markerMap[id] = marker;
						},
						clearMap : function() {
							for ( var key in this.markerMap) {
								if (that.markerMap.hasOwnProperty(key)) {
									var marker = that.markerMap[key]
									marker.setMap(null);
									delete that.markerMap[key];
								}
							}
						},
						showMovies : function(results) {
							if (results.pageItems && results.pageNumber) {
								that.clearMap();
								var $movieLocationDetailsDiv = $('#movieLocationDetailsDiv');
								$movieLocationDetailsDiv.empty();
								that.currPageNo = +results.pageNumber;
								that.totalPages = +results.pagesAvailable;
								var movieItemsHtml = "";
								var pageItems = results.pageItems;
								if (Object.prototype.toString.call(pageItems) === '[object Array]') {
									for (var i = 0; i < results.pageItems.length; i++) {
										var $movieItem = $(MOVIE_VIEW_DIV_TEMPELATE
												.replace("{!id_placeholder}",
														pageItems[i].id)
												.replace(
														"{!heading_placheholder}",
														pageItems[i].title)
												.replace(
														"{!movie_release_year_placeholder}",
														pageItems[i].releaseYear)
												.replace(
														"{!movie_director_placeholder}",
														pageItems[i].director)
												.replace(
														"{!movie_address_location}",
														pageItems[i].formattedAddress));
										$movieItem.attr('data-id',
												pageItems[i].id);
										movieItemsHtml += $movieItem
												.outerHTML();
										that
												.addMapMarker(
														pageItems[i].id,
														pageItems[i].geoCodeCoordinatesEntity,
														pageItems[i].title);
									}
								} else {
									var $movieItem = $(MOVIE_VIEW_DIV_TEMPELATE
											.replace("{!id_placeholder}",
													pageItems.id)
											.replace("{!heading_placheholder}",
													pageItems.title)
											.replace(
													"{!movie_release_year_placeholder}",
													pageItems.releaseYear)
											.replace(
													"{!movie_director_placeholder}",
													pageItems.director)
											.replace(
													"{!movie_address_location}",
													pageItems.formattedAddress));
									$movieItem.attr('data-id', pageItems.id);
									movieItemsHtml += $movieItem.outerHTML();
									that.addMapMarker(pageItems.id,
											pageItems.geoCodeCoordinatesEntity,
											pageItems.title);
								}
								$movieLocationDetailsDiv.append(movieItemsHtml);
							}
							that.attachHandellers(results);
							that.toogleMoreButton();
						},
						attachHandellers : function(results) {
							var pageItems = results.pageItems;
							for (var i = 0; i < pageItems.length; i++) {
								var $movieItem = $("#movie-" + pageItems[i].id);
								$movieItem.mouseenter(function(event) {
									that.toggleMarkerBounce(event)
								});
								$movieItem.mouseleave(function(event) {
									that.toggleMarkerBounce(event)
								});
							}
						},
						toggleMarkerBounce : function(event) {
							$target = $(event.currentTarget);
							var id = $target.data("id");
							var marker = that.markerMap[id];
							if (marker.getAnimation() != null) {
								marker.setAnimation(null);
							} else {
								marker
										.setAnimation(google.maps.Animation.BOUNCE);
							}
						},
						fetchNextPage : function(title) {
							var currPage = that.currPageNo;
							if (currPage < that.totalPages
									|| that.totalPages === 0) {
							}
							MovieService.getMovies(that.title, currPage + 1, 4,
									SfMoiveView.showMovies);
						},
						toogleMoreButton : function() {
							var $moreMoviesBtn = $("#btn-moreMovies");
							if (that.currPageNo < that.totalPages) {
								if(!$moreMoviesBtn.is(':visible')){
								$("#btn-moreMovies").show();
								}
							} else {
								if($moreMoviesBtn.is(':visible')){
								$("#btn-moreMovies").hide();
								}
							}
						}
					}.init();

					function fetchNextPage() {
						that.fetchNextPage();

					}
					$("#btn-moreMovies").click(function(event) {
						if (that.currPageNo < that.totalPages) {
						fetchNextPage()
						}
					})
					
					function typeAhead() {
						$("#typeahead").typeahead(
								{
									source : function(query, process) {
										$.ajax({
											url : SERVICE_URL_PREFIX
													+ SEARCH_SERVICE_PATH_URL
													+ "/movies?title=" + query
													+ "&limit=10",
											type : "GET",
											dataType : "JSON",
											async : true,
											success : function(data) {
												if (data.titles) {
													if (Object.prototype.toString.call(data.titles) === '[object Array]'){
													process(data.titles);
													} else {
														process([data.titles]);
													}
												}
											}
										});
									}
								});
					}
					;
					$("#btn-search").click(function(event) {
						searchButtonClickHandeler()
					});
					function searchButtonClickHandeler() {
						var title = $("#typeahead").val();
						that.title = title;
						MovieService.getMovies(title, 1, 4,
								SfMoiveView.showMovies);
					}
					typeAhead();
					fetchNextPage(undefined);

				});
