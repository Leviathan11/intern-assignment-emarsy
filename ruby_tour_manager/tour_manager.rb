class Location
  def initialize(name, closer_location = nil)
    @name = name
    @closer_location = closer_location if closer_location.is_a? Location
  end

  def name
    @name
  end

  def closer_location
    @closer_location
  end
end

#method that logically orders locations to an array
def calculate_sequence(*locations)
  sequence = []
  locations.each { |location| add_to_sequence(sequence, locations, location); break if sequence.size == locations.size}
  return sequence
end

#recursive method, called by the calculate_sequence
def add_to_sequence(sequence, locations, location)
  unless sequence.include? location
    dependency = location.closer_location
    add_to_sequence(sequence, locations, dependency) if !dependency.nil? && locations.include?(dependency)
    sequence << location
  end
end

#example4
u = Location.new("U")
x = Location.new("X", u)
z = Location.new("Z")
w = Location.new("W", z)
v = Location.new("V", w)
y = Location.new("Y", v)
calculate_sequence(u, v, w, x, y, z).each { |loc| print loc.name}
