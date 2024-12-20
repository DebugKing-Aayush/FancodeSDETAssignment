package api.payloads;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
	private int id;
	private String name;
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public static class Address {
		private Geo geo;
		private String street;
        public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getSuite() {
			return suite;
		}

		public void setSuite(String suite) {
			this.suite = suite;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getZipcode() {
			return zipcode;
		}

		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}

		private String suite;
        private String city;  // The city should be part of Address
        private String zipcode;


		public Geo getGeo() {
			return geo;
		}

		public void setGeo(Geo geo) {
			this.geo = geo;
		}

		public static class Geo {
			private double lat;
			private double lng;

			// Getters and Setters for Geo
			public double getLat() {
				return lat;
			}

			public void setLat(double lat) {
				this.lat = lat;
			}

			public double getLng() {
				return lng;
			}

			public void setLng(double lng) {
				this.lng = lng;
			}
		}
	}
}
